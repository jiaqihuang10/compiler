package ast;

public class ParenExpression extends Expression {
    Expression expr;

    public ParenExpression (Expression e) {
        expr = e;
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
}
