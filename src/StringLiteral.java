package ast;

public class StringLiteral extends Expression {

    public String str;

    public StringLiteral(String s) {
        str = s;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
