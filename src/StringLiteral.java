package ast;

<<<<<<< HEAD
import type.*;
import semantics.*;

public class StringLiteral extends Expression {
    public String str;
    int line;
    int offset;

    public StringLiteral(String s, int l, int o) {
        str = s;
        line = l;
        offset = o;
    }

    public int getLine(){
        return line;
    }

    public int getOffset(){
        return offset;
=======
public class StringLiteral extends Expression {

    public String str;

    public StringLiteral(String s) {
        str = s;
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
