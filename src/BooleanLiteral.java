package ast;

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
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
    public Type accept(TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
}
