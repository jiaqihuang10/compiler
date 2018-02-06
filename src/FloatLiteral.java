package ast;

public class FloatLiteral extends Expression {

    Float val;

    public FloatLiteral(Float ff) {
        val = ff;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
