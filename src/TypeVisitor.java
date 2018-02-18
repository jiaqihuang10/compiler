package semantics;

import type.*;
import ast.*;

public interface TypeVisitor {
    public Type visit (Program p) throws SemanticException;
    public Type visit (Function f) throws SemanticException;
    public Type visit (FunctionDeclaration fd) throws SemanticException;
    public Type visit (FunctionBody fb) throws SemanticException;
    public Type visit (AddExpression ad) throws SemanticException;
    public Type visit (ArrayAssignmentStatement aa) throws SemanticException;
    public Type visit (ArrayReferenceExpression ar) throws SemanticException;
    public Type visit (AssignmentStatement as)  throws SemanticException;
    public Type visit (Block b) throws SemanticException ;
    public Type visit (EqualExpression ee) throws SemanticException;
    public Type visit (ExpressionStatement es)throws SemanticException;
    public Type visit (FormalParameter fp)throws SemanticException;
    public Type visit (FunctionCallExpression ece)throws SemanticException;
    public Type visit (Identifier i)throws SemanticException;
    public Type visit (IdentifierReference ir) throws SemanticException;
    public Type visit (IfStatement is)throws SemanticException;
    public Type visit (LessthanExpression le) throws SemanticException;
    public Type visit (MultiExpression me) throws SemanticException;
    public Type visit (ParameterList pl) throws SemanticException;
    public Type visit (ParenExpression pe) throws SemanticException;
    public Type visit (PrintStatement ps)throws SemanticException;
    public Type visit (PrintlnStatement pl)throws SemanticException;
    public Type visit (ReturnStatement rs)throws SemanticException;
    public Type visit (StatementList sl)throws SemanticException;
    public Type visit (SubtractExpression se) throws SemanticException;
    public Type visit (TypeNode t)throws SemanticException;
    public Type visit (VariableDeclaration vd)throws SemanticException;
    public Type visit (VariableDeclarationList vdl) throws SemanticException;
    public Type visit (WhileStatement ws)throws SemanticException;
    public Type visit (IntegerLiteral il)throws SemanticException;
    public Type visit (StringLiteral sl)throws SemanticException;
    public Type visit (FloatLiteral fl)throws SemanticException;
    public Type visit (CharacterLiteral cl)throws SemanticException;
    public Type visit (BooleanLiteral bl)throws SemanticException;

}
