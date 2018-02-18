package ast;

<<<<<<< HEAD
import type.*;
import semantics.*;

public class IntegerLiteral extends Expression {
    Integer val;
    int line;
    int offset;

    public IntegerLiteral(Integer i, int l, int o) {
        val = i;
        line = l;
        offset = o;
=======
public class IntegerLiteral extends Expression {

    Integer val;

    public IntegerLiteral(Integer i) {
        val = i;
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
    }

    public int getVal() {
        return val.intValue();
    }
<<<<<<< HEAD

    public int getLine() {
        return line;
    }

    public int getOffset() {
        return offset;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) throws SemanticException{
        return v.visit(this);
    }

=======
    public void accept(Visitor v) {
        v.visit(this);
    }
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
