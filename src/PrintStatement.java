package ast;

public class PrintStatement extends Statement {
    Expression expr;

    public PrintStatement (Expression e) {
        expr = e;
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
}
