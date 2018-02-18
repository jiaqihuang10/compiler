package ast;

import type.*;
import semantics.*;

public class TypeNode extends ASTNode {
    public Type type;
    int line;
    int offset;

    public TypeNode(Type t, int l, int o) {
        type = t;
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
