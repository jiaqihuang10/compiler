package ast;

public class ArrayReferenceExpression extends Expression {
    Expression expr;
    Identifier id;

    public ArrayReferenceExpression (Identifier i, Expression e) {
        id = i;
        expr = e;
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
}
