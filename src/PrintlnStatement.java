package ast;

public class PrintlnStatement extends Statement {
    Expression expr;

    public PrintlnStatement (Expression e) {
        expr = e;
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
}
