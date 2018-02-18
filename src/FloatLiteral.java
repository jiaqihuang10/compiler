package ast;

<<<<<<< HEAD
import type.*;
import semantics.*;

public class FloatLiteral extends Expression {
    Float val;
    int line;
    int offset;
    public FloatLiteral(Float ff, int l, int o) {
        val = ff;
        line = l;
        offset = o;
    }

    public int getLine(){
        return line;
    }

    public int getOffset(){
        return offset;
=======
public class FloatLiteral extends Expression {

    Float val;

    public FloatLiteral(Float ff) {
        val = ff;
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
