package ast;

public interface Visitor {
    public Object visit (Program p);
    public Object visit (Function f);
    public Object visit (FunctionDeclaration fd);
    public Object visit (FunctionBody fb);
    public Object visit (AddExpression ad);
    public Object visit (ArrayAssignmentStatement aa);
    public Object visit (ArrayReferenceExpression ar);
    public Object visit (AssignmentStatement as);
    public Object visit (Block b);
    public Object visit (EqualExpression ee);
    public Object visit (ExpressionStatement es);
    public Object visit (FormalParameter fp);
    public Object visit (FunctionCallExpression ece);
    public Object visit (Identifier i);
    public Object visit (IdentifierReference ir);
    public Object visit (IfStatement is);
    public Object visit (LessthanExpression le);
    public Object visit (MultiExpression me);
    public Object visit (ParameterList pl);
    public Object visit (ParenExpression pe);
    public Object visit (PrintStatement ps);
    public Object visit (PrintlnStatement pl);
    public Object visit (ReturnStatement rs);
    public Object visit (StatementList sl);
    public Object visit (SubtractExpression se);
    public Object visit (TypeNode t);
    public Object visit (VariableDeclaration vd);
    public Object visit (VariableDeclarationList vdl);
    public Object visit (WhileStatement ws);
    public Object visit (IntegerLiteral il);
    public Object visit (StringLiteral sl);
    public Object visit (FloatLiteral fl);
    public Object visit (CharacterLiteral cl);
    public Object visit (BooleanLiteral bl);
}
