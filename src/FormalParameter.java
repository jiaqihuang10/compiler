package ast;

import semantics.*;
import type.*;

public class FormalParameter extends ASTNode {
    TypeNode tn;
    Identifier id;

    public FormalParameter (TypeNode t, Identifier i) {
        tn = t;
        id = i;
    }

    public Identifier getParaId() {
        return id;
    }

    public TypeNode getParaType() {
        return tn;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
}
