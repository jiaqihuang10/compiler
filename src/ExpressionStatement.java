package ast;

public class ExpressionStatement extends Statement {
    Expression expr;

    public ExpressionStatement (Expression e) {
        expr = e;
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
}
