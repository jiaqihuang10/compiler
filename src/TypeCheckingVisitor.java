package semantics;

import type.*;
import ast.*;
import environment.*;
import java.util.*;

public class TypeCheckingVisitor implements TypeVisitor {
    Environment variableTable;
    Environment functionTable;
    String currentFunc;
    String currentVar;

    public TypeCheckingVisitor() {
        variableTable = new ListEnvironment<String,Type>();
        functionTable = new ListEnvironment<String,FunctionDeclaration>();
    }

    public Type visit (Program p)throws SemanticException{
        boolean mainExists = false;
        Enumeration fEnum = p.flist.elements();
        while (fEnum.hasMoreElements()) {
            Function f = (Function)fEnum.nextElement();
            if(f.getFuncName().equals("main")) {
                mainExists = true;
                verifyMain(f);
            }
            f.accept(this);
        }
        if (!mainExists) {
            //print main does not exist error
            System.out.println("Error: No main function found.");
            System.exit(0);
        }
        return null;
    }

    public void verifyMain(Function f) throws SemanticException {
        FunctionDeclaration fd = f.funcDecl;
        //no parameter
        if(fd.getParaSize() != 0) {
            String errmsg = "parameters found in main function";
            //System.out.println("line: " + fd.getFuncId().getLine());
            throw new SemanticException(errmsg,fd.getFuncId().getLine(), fd.getFuncId().getOffset());
        }
        //return type of void
        if (!(fd.getReturnType().type instanceof VoidType)) {
            String errmsg = "Invalid return type of main.";
            throw new SemanticException(errmsg,fd.getReturnType().getLine(), fd.getReturnType().getOffset());
        }
    }

    public Type visit (Function f) throws SemanticException{
        Type declReturnType = f.funcDecl.accept(this);
        Type bodyReturnTYpe = f.funcBody.accept(this);
        return null;
    }

    public Type visit (FunctionDeclaration fd) throws SemanticException{
        if (functionTable.inCurrentScope(fd.getFuncId().name)) {
            String errmsg = "Redefinition of function - " + fd.getFuncId().name;
            throw new SemanticException(errmsg, fd.getFuncId().getLine(), fd.getFuncId().getOffset());
        }
        functionTable.add(fd.getFuncId().name, fd);
        variableTable.beginScope();
        fd.getFuncId().accept(this);
        fd.getParaList().accept(this);
        //System.out.println("function:");
        //functionTable.printList();
        return fd.getReturnType().type;  //return its returnType
    }

    public Type visit (FunctionBody fb) throws SemanticException {
        fb.vdl.accept(this);
        Type returnType = fb.stml.accept(this);
        //variableTable.printList();
        variableTable.endScope();
        //System.out.println("------");
        return returnType;
    }
    public Type visit (AddExpression ad) throws SemanticException {
        Type eType1 = ad.getExpr1().accept(this);
        Type eType2 = ad.getExpr2().accept(this);
        String errmsg;
        if (!(eType1.toString()).equals(eType2.toString())) {
            errmsg = "Cannot add " + eType2 + " to " + eType1;
            throw new SemanticException(errmsg, ad.getExpr2().getLine(), ad.getExpr2().getOffset());
        } else {
            if (eType1 instanceof BooleanType) {
                errmsg = "Cannot apply addition to boolean type.";
                throw new SemanticException(errmsg, ad.getExpr1().getLine(), ad.getExpr1().getOffset());
            }
            if (eType1 instanceof VoidType) {
                errmsg = "Cannot apply addition to void type.";
                throw new SemanticException(errmsg, ad.getExpr1().getLine(), ad.getExpr1().getOffset());
            }
        }
        return eType1;
    }

    public Type visit (ArrayAssignmentStatement aa)throws SemanticException  {
        //System.out.println("assigning array.");
        Type arrType = aa.getArrayReference().accept(this);
        Type exprType = aa.getExpr().accept(this);
        System.out.println("array: " + arrType + " expr: " + exprType);

        if (!(arrType.toString()).equals(exprType.toString())) {
            String errmsg = "Cannot assign " + exprType + " to an element of array of type " + arrType;
            throw new SemanticException(errmsg,aa.getExpr().getLine(),aa.getExpr().getOffset());
        }
        return null;
    }

    public Type visit (ArrayReferenceExpression ar) throws SemanticException {
        //System.out.println("referencing array.");
        String errmsg;
        Type arrType = (Type)variableTable.lookup(ar.getId().name);
        if (arrType == null) {
            errmsg = ar.getId() + " does not exist.";
            throw new SemanticException(errmsg, ar.getId().getLine(), ar.getId().getOffset());
        }
        if (!(arrType instanceof ArrayType)) {
            errmsg = ar.getId() + " is not an array, cannot be accessed using [].";
            throw new SemanticException(errmsg, ar.getId().getLine(), ar.getId().getOffset());
        } else {
            Type index = ar.getExpr().accept(this);
            if (!(index instanceof IntegerType)) {
                errmsg = "Array index must be integer.";
                throw new SemanticException(errmsg, ar.getExpr().getLine(), ar.getExpr().getOffset());
            }
            return ((ArrayType)arrType).getTypeOfArray();
        }

    }

    public Type visit (AssignmentStatement as) throws SemanticException {
        //System.out.println("visiting AssignmentStatement.");
        Type irType = as.getIdr().accept(this);
        Type exprType = as.getExpr().accept(this);
        if(!(irType.toString()).equals(exprType.toString())) {
            String errmsg = "Type " + exprType + " cannot be assigned to " + irType;
            throw new SemanticException(errmsg, as.getIdr().getLine(), as.getIdr().getOffset());
        }
        return null;
    }
    public Type visit (Block b) throws SemanticException {
        variableTable.beginScope();
        Enumeration stmEnum = b.getStatementList().slist.elements();
        while (stmEnum.hasMoreElements()) {
            Statement s = (Statement)stmEnum.nextElement();
            s.accept(this);
        }
        variableTable.endScope();
        return null;
    }

    public Type visit (EqualExpression ee) throws SemanticException {
        Type eType1 = ee.getExpr1().accept(this);
        Type eType2 = ee.getExpr2().accept(this);
        String errmsg;
        //System.out.println("expr1: " + eType1 + " expr2: " + eType2);
        if (!(eType1.toString()).equals(eType2.toString())) {
            errmsg = "Cannot compare " + eType2 + " with " + eType1;
            throw new SemanticException(errmsg, ee.getExpr2().getLine(), ee.getExpr2().getOffset());
        } else {
            if (eType1 instanceof VoidType) {
                errmsg = "Cannot apply equality to void type.";
                throw new SemanticException(errmsg, ee.getExpr1().getLine(), ee.getExpr1().getOffset());
            }
        }
        return new BooleanType();
    }

    public Type visit (ExpressionStatement es) throws SemanticException {
        Expression expr = es.getExpr();
        return expr.accept(this);
    }

    public Type visit (FormalParameter fp) throws SemanticException{
        String paraName = fp.getParaId().name;
        if (variableTable.inCurrentScope(paraName)) {
            String errmsg = "Duplicate parameter name.";
            throw new SemanticException(errmsg,fp.getParaId().getLine(), fp.getParaId().getOffset());
        }
        if (fp.getParaType().type instanceof VoidType) {
            String errmsg = "Parameter has type void.";
            throw new SemanticException(errmsg,fp.getParaType().getLine(), fp.getParaType().getOffset());
        }
        variableTable.add(paraName, fp.getParaType().type);
        return fp.getParaType().type;
    }

    public Type visit (FunctionCallExpression ece) throws SemanticException {
        //System.out.println("checking function call");
        String funcName = ece.getFuncId().name;
        //check number of arguments
        FunctionDeclaration funcDecl = (FunctionDeclaration)functionTable.lookup(funcName);
        if (funcDecl.getParaSize() != ece.argSize()) {
            String errmsg = funcName + " - Expected: " + funcDecl.getParaSize() + " arguments. Found: " + ece.argSize();
            throw new SemanticException(errmsg, ece.getFuncId().getLine(), ece.getFuncId().getOffset());
        }
        //check if types of arguments match parameters
        Enumeration paraEnum = funcDecl.getParaList().paralist.elements();
        Enumeration argEnum = ece.getArglist().elements();
        while (argEnum.hasMoreElements()) {
            //get arg type
            Expression argExpr = (Expression)argEnum.nextElement();
            Type argType = argExpr.accept(this);
            Type paraType = ((FormalParameter)paraEnum.nextElement()).accept(this);
            if (!(argType.toString()).equals(paraType.toString())) {
                String errmsg = "Expected: " + paraType + ". Found: " + argType;
                throw new SemanticException(errmsg, argExpr.getLine(), argExpr.getOffset());
            }
        }
        //return the return type of funcDecl
        return funcDecl.getReturnType().type;
    }
    public Type visit (Identifier i) throws SemanticException {return null;}

    public Type visit (IdentifierReference ir) throws SemanticException {
        //System.out.println("visiting id reference.");
        if (!variableTable.inCurrentScope(ir.name)) {
            String msg = "Unknown symbol: " + ir.name + " not declared.";
            throw new SemanticException(msg, ir.getLine(), ir.getOffset());
        }
        Type irType = (Type)variableTable.lookup(ir.name);
        return irType;
    }

    public Type visit (IfStatement is) throws SemanticException {
        Type cond = is.getCondExpr().accept(this);
        if (!(cond instanceof BooleanType)) {
            String errmsg = "Condition expression of if-statement must have boolean type.";
            throw new SemanticException(errmsg,is.getLine(),is.getOffset());
        }
        return null;
    }
    public Type visit (LessthanExpression le) throws SemanticException{
        Type eType1 = le.getExpr1().accept(this);
        Type eType2 = le.getExpr2().accept(this);
        String errmsg;
        if (!(eType1.toString()).equals(eType2.toString())) {
            errmsg = "Cannot compare " + eType2 + " with " + eType1;
            throw new SemanticException(errmsg, le.getExpr2().getLine(), le.getExpr2().getOffset());
        } else {
            if (eType1 instanceof VoidType) {
                errmsg = "Cannot apply comparison to void type.";
                throw new SemanticException(errmsg, le.getExpr1().getLine(), le.getExpr1().getOffset());
            }
        }
        return new BooleanType();
    }

    public Type visit (MultiExpression me) throws SemanticException {
        Type eType1 = me.getExpr1().accept(this);
        Type eType2 = me.getExpr2().accept(this);
        String errmsg;
        if (!((eType1.toString()).toString()).equals(eType2.toString())) {
            errmsg = "Cannot multiply " + eType2 + " with " + eType1;
            throw new SemanticException(errmsg, me.getExpr2().getLine(), me.getExpr2().getOffset());
        } else {
            if (!(eType1 instanceof IntegerType || eType1 instanceof FloatType)) {
                errmsg = "Cannot apply multiplication to " + eType1 + " type.";
                throw new SemanticException(errmsg, me.getExpr1().getLine(), me.getExpr1().getOffset());
            }
        }
        return eType1;
    }

    public Type visit (ParameterList pl) throws SemanticException {
        //no two parameters can have the same name
        Enumeration paraEnum = pl.paralist.elements();
        while (paraEnum.hasMoreElements()) {
            FormalParameter fp = (FormalParameter)paraEnum.nextElement();
            fp.accept(this);
        }
        return null;
    }
    public Type visit (ParenExpression pe) throws SemanticException {
        return pe.getExpr().accept(this);
    }

    public Type visit (PrintStatement ps) throws SemanticException {
        Type exprType = ps.getPrintExpr().accept(this);
        if (exprType == null) {
            String errmsg = "Cannot print null.";
            throw new SemanticException(errmsg, ps.getLine(), ps.getOffset());
        }
        if (exprType instanceof ArrayType) {
            String errmsg = "Cannot print array.";
            throw new SemanticException(errmsg, ps.getLine(), ps.getOffset());
        }
        return null;
    }

    public Type visit (PrintlnStatement pl) throws SemanticException {
        Type exprType = pl.getPrintlnExpr().accept(this);
        if (exprType == null) {
            String errmsg = "Cannot print null.";
            throw new SemanticException(errmsg, pl.getLine(), pl.getOffset());
        }
        if (exprType instanceof ArrayType) {
            String errmsg = "Cannot print array.";
            throw new SemanticException(errmsg, pl.getLine(), pl.getOffset());
        }
        return null;
    }

    public Type visit (ReturnStatement rs) throws SemanticException {
        return rs.getExpr().accept(this);
    }

    public Type visit (StatementList sl) throws SemanticException {
        Enumeration sEnum = sl.slist.elements();
        Type returnType = null; //set the type of statementlist to be the type of return statement if any
        while(sEnum.hasMoreElements()) {
            Statement s = (Statement)sEnum.nextElement();
            if (s instanceof ReturnStatement) {
                returnType = s.accept(this);
            }
            s.accept(this);
        }
        return returnType;
    }

    public Type visit (SubtractExpression se) throws SemanticException {
        Type eType1 = se.getExpr1().accept(this);
        Type eType2 = se.getExpr2().accept(this);
        String errmsg;
        if (!(eType1.toString()).equals(eType2.toString())) {
            errmsg = "Cannot subtract " + eType2 + " from " + eType1;
            throw new SemanticException(errmsg, se.getExpr2().getLine(), se.getExpr2().getOffset());
        } else {
            if (eType1 instanceof BooleanType) {
                errmsg = "Cannot apply subtraction to boolean type.";
                throw new SemanticException(errmsg, se.getExpr1().getLine(), se.getExpr1().getOffset());
            }
            if (eType1 instanceof VoidType) {
                errmsg = "Cannot apply subtraction to void type.";
                throw new SemanticException(errmsg, se.getExpr1().getLine(), se.getExpr1().getOffset());
            }
            if (eType1 instanceof StringType) {
                errmsg = "Cannot apply subtraction to string type.";
                throw new SemanticException(errmsg, se.getExpr1().getLine(), se.getExpr1().getOffset());
            }
        }
        return eType1;
    }
    public Type visit (TypeNode t) throws SemanticException {return null;}

    public Type visit (VariableDeclaration vd) throws SemanticException {
        String varName = vd.getVarId().name;
        if (variableTable.inCurrentScope(varName)) {
            String errmsg = "Variable " + varName + " already declared.";
            throw new SemanticException(errmsg,vd.getVarId().getLine(), vd.getVarId().getOffset());
        }
        if (vd.getVarType().type instanceof VoidType) {
            String errmsg = "Variable " + varName + " has type void.";
            throw new SemanticException(errmsg,vd.getVarType().getLine(), vd.getVarType().getOffset());
        }
        variableTable.add(varName, vd.getVarType().type);
        return vd.getVarType().type;
    }

    public Type visit (VariableDeclarationList vdl) throws SemanticException {
        Enumeration vEnum = vdl.vlist.elements();
        while (vEnum.hasMoreElements()) {
            VariableDeclaration v = (VariableDeclaration)vEnum.nextElement();
            v.accept(this);
        }
        return null;
    }

    public Type visit (WhileStatement ws)  throws SemanticException {
        Type cond = ws.getCondExpr().accept(this);
        if (!(cond instanceof BooleanType)) {
            String errmsg = "Condition expression of while-statement must have boolean type.";
            throw new SemanticException(errmsg,ws.getLine(),ws.getOffset());
        }
        return null;
    }

    public Type visit (IntegerLiteral il) throws SemanticException {
        return new IntegerType();
    }
    public Type visit (StringLiteral sl) throws SemanticException {
        return new StringType();}
    public Type visit (FloatLiteral fl) throws SemanticException {
        return new FloatType();}
    public Type visit (CharacterLiteral cl) throws SemanticException {
        return new CharType();}
    public Type visit (BooleanLiteral bl) throws SemanticException {
        return new BooleanType();}

}
