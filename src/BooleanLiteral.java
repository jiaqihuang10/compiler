package ast;

<<<<<<< HEAD
import type.*;
import semantics.*;

public class BooleanLiteral extends Expression {
    boolean val;
    int line;
    int offset;

    public BooleanLiteral(boolean v, int l, int o) {
        val = v;
        line = l;
        offset = o;
    }

    public int getLine(){
        return line;
    }

    public int getOffset(){
        return offset;
=======
public class BooleanLiteral extends Expression {

    boolean val;

    public BooleanLiteral(boolean v) {
        val = v;
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
