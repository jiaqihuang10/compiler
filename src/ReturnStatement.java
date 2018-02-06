package ast;

public class ReturnStatement extends Statement {
    Expression expr;

    public ReturnStatement (Expression e) {
        expr = e;
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
}
