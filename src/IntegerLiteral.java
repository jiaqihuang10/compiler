package ast;

public class IntegerLiteral extends Expression {

    Integer val;

    public IntegerLiteral(Integer i) {
        val = i;
    }

    public int getVal() {
        return val.intValue();
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
