package ast;

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
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
}
