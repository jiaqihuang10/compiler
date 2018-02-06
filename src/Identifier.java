package ast;

public class Identifier extends Expression {
    String name;

    public Identifier (String n) {
        name = n;
    }

    public String toString() {
        return name;
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
}
