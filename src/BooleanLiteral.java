package ast;

public class BooleanLiteral extends Expression {

    boolean val;

    public BooleanLiteral(boolean v) {
        val = v;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
