package ast;

import type.*;
<<<<<<< HEAD
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

=======

public class TypeNode extends ASTNode {
    Type tp;

    public TypeNode(Type t) {
        tp = t;
    }

    public Type getType() {
        return tp;
    }
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
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
