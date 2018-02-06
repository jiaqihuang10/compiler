package ast;

public class EqualExpression extends Expression {
    Expression expr1;
    Expression expr2;

    public EqualExpression (Expression e1, Expression e2) {
        expr1 = e1;
        expr2 = e2;
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
}
