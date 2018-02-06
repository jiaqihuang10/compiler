package ast;

import type.*;

public class TypeNode extends ASTNode {
    Type tp;

    public TypeNode(Type t) {
        tp = t;
    }

    public Type getType() {
        return tp;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
