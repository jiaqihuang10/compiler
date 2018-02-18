package ast;

import semantics.*;
import type.*;

public abstract class Expression extends ASTNode {
    public abstract Type accept (TypeVisitor v) throws SemanticException;
    public abstract void accept (Visitor v);
    public abstract int getLine();
    public abstract int getOffset();
}
