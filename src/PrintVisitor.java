package ast;

import java.util.*;

public class PrintVisitor implements Visitor {
    int levelCount = 0;

    public Object visit (Program p) {
        Enumeration fEnum = p.flist.elements();
        while (fEnum.hasMoreElements()) {
            Function f = (Function)fEnum.nextElement();
            f.accept(this);
        }

        return null;
    }

    public Object visit (Function f) {
        f.funcDecl.accept(this);
        f.funcBody.accept(this);

        return null;
    }

    public Object visit (Identifier id) {
        System.out.print(id.name);

        return null;
    }

<<<<<<< HEAD
    public Object visit (IdentifierReference ir) {
        System.out.print(ir.name);

        return null;
    }

=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
    public Object visit (FunctionDeclaration fd) {
        fd.returnType.accept(this);
        System.out.print(" ");
        fd.funcName.accept(this);
        System.out.print(" (");
        fd.pl.accept(this);
        System.out.println(")");

        return null;
    }

    public Object visit (StatementList sl) {
        //enumerate statements
        Enumeration stmEnum = sl.slist.elements();
        while (stmEnum.hasMoreElements()) {
            System.out.print("    ");
            Statement s = (Statement)stmEnum.nextElement();
            s.accept(this);
        }

        return null;
    }

    public Object visit (VariableDeclarationList vdl) {
        Enumeration vEnum = vdl.vlist.elements();
        while (vEnum.hasMoreElements()) {
            System.out.print("    ");
            VariableDeclaration v = (VariableDeclaration)vEnum.nextElement();
            v.accept(this);
        }

        return null;
    }

    //fix
    public Object visit (FunctionBody fb) {
        System.out.println("{");
        //enumerate var declarations
        fb.vdl.accept(this);
        if (fb.vdl.size() != 0) {
            System.out.println();
        }

        //enumerate statements
        fb.stml.accept(this);
        System.out.println("}");
        System.out.println();

        return null;
    }

    public Object visit (FormalParameter fp) {
        fp.tn.accept(this);
        System.out.print(" ");
        fp.id.accept(this);

        return null;
    }

    public Object visit (ParameterList pl) {
        Enumeration pEnum = pl.paralist.elements();
        while (pEnum.hasMoreElements()) {
            FormalParameter p = (FormalParameter)pEnum.nextElement();
            p.accept(this);
            if (pEnum.hasMoreElements()) {
                System.out.print(", ");
            }

        }

        return null;
    }

    public Object visit (VariableDeclaration vd) {
        vd.tn.accept(this);
        System.out.print(" ");
        vd.id.accept(this);
        System.out.println(";");

        return null;
    }

    public Object visit (TypeNode tn) {
<<<<<<< HEAD
        System.out.print(tn.type);
=======
        System.out.print(tn.tp);
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
        return null;
    }

    //statements
    public Object visit (ArrayAssignmentStatement aas) {
<<<<<<< HEAD
        aas.are.accept(this);
    /*    System.out.print("[");
        aas.are.accept(this);
        System.out.print("]"); */
        System.out.print("=");
        aas.expr.accept(this);
=======
        aas.id.accept(this);
        System.out.print("[");
        aas.expr1.accept(this);
        System.out.print("]");
        System.out.print("=");
        aas.expr2.accept(this);
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
        System.out.println(";");

        return null;
    }

    public Object visit (AssignmentStatement as) {
        as.id.accept(this);
        System.out.print("=");
        as.expr.accept(this);
        System.out.println(";");

        return null;
    }

    public Object visit (ExpressionStatement es) {
        es.expr.accept(this);
        System.out.println(";");

        return null;
    }

    public Object visit (IfStatement is) {
        System.out.print("if (");
        is.expr.accept(this);
        System.out.println(")");
        levelCount++;
        is.blk1.accept(this);
        if(is.blk2 != null) {
            printIdentation(levelCount);
            System.out.println("else");
            is.blk2.accept(this);
        }
        levelCount--;

        return null;
    }

    public Object visit (WhileStatement ws) {
        System.out.print("while (");
        ws.expr.accept(this);
        System.out.println(")");
        levelCount++;
        ws.blk.accept(this);
        levelCount--;

        return null;
    }

    public Object visit (ReturnStatement rs) {
        System.out.print("return");
        if (rs.expr != null) {
            System.out.print(" ");
            rs.expr.accept(this);

        }
        System.out.println(";");

        return null;
    }

    public Object visit (PrintStatement ps) {
        System.out.print("print ");
        ps.expr.accept(this);
        System.out.println(";");

        return null;
    }

    public Object visit (PrintlnStatement ps) {
        System.out.print("println ");
        ps.expr.accept(this);
        System.out.println(";");

        return null;
    }

    public Object visit (Block b) {
        printIdentation(levelCount);
        System.out.println("{");
        Enumeration stmEnum = b.l.slist.elements();
        while (stmEnum.hasMoreElements()) {
            Statement s = (Statement)stmEnum.nextElement();
            System.out.print("    ");
            printIdentation(levelCount);
            s.accept(this);
        }
        printIdentation(levelCount);
        System.out.println("}");

        return null;
    }

    //expressions
    public Object visit (AddExpression ae) {
        ae.expr1.accept(this);
        System.out.print("+");
        ae.expr2.accept(this);

        return null;
    }

    public Object visit (ArrayReferenceExpression are) {
        are.id.accept(this);
        System.out.print("[");
        are.expr.accept(this);
        System.out.print("[");

        return null;
    }

    public Object visit (EqualExpression ee) {
        ee.expr1.accept(this);
        System.out.print("==");
        ee.expr2.accept(this);

        return null;
    }

    public Object visit (LessthanExpression le) {
        le.expr1.accept(this);
        System.out.print("<");
        le.expr2.accept(this);

        return null;
    }

    public Object visit (SubtractExpression se) {
        se.expr1.accept(this);
        System.out.print("-");
        se.expr2.accept(this);

        return null;
    }

    public Object visit (MultiExpression me) {
        me.expr1.accept(this);
        System.out.print("*");
        me.expr2.accept(this);
        return null;
    }

    public Object visit (FunctionCallExpression fce) {
        fce.id.accept(this);
        System.out.print("(");
<<<<<<< HEAD
        Enumeration fceEnum = fce.arglist.elements();
=======
        Enumeration fceEnum = fce.paralist.elements();
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
        while (fceEnum.hasMoreElements()) {
            Expression e = (Expression)fceEnum.nextElement();
            e.accept(this);
            if (fceEnum.hasMoreElements()) {
                System.out.print(",");
            }
        }
        System.out.print(")");

        return null;
    }

    public Object visit (ParenExpression pe) {
        System.out.print("(");
        pe.expr.accept(this);
        System.out.print(")");

        return null;
    }

    public Object visit (IntegerLiteral il){

        //il.accept(this);
        int v = il.val.intValue();
        System.out.print(v);

        return null;
    }

    public Object visit (StringLiteral sl){
        //sl.accept(this);
        System.out.print(sl.str);

        return null;
    }

    public Object visit (FloatLiteral fl) {
        //fl.accept(this);
        float f = fl.val.floatValue();
        System.out.print(f);

        return null;
    }

    public Object visit (CharacterLiteral cl) {
        //cl.accept(this);
        System.out.print(cl.c);

        return null;
    }

    public Object visit (BooleanLiteral bl) {
        //bl.accept(this);
        System.out.print(bl.val);

        return null;

    }

    public void printIdentation(int n) {
        for (int i=0; i<n;i++) {
            System.out.print("    ");
        }
    }

}
