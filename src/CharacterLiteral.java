package ast;

<<<<<<< HEAD
import type.*;
import semantics.*;

public class CharacterLiteral extends Expression {

    String c;
    int line;
    int offset;

    public CharacterLiteral(String cc, int l, int o) {
        c = cc;
        line = l;
        offset = o;
    }

    public int getLine(){
        return line;
    }

    public int getOffset(){
        return offset;
=======
public class CharacterLiteral extends Expression {

    String c;

    public CharacterLiteral(String cc) {
        c = cc;
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
<<<<<<< HEAD

    public Type accept(TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
