package ast;

public class CharacterLiteral extends Expression {

    String c;

    public CharacterLiteral(String cc) {
        c = cc;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
