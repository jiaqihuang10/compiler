package ast;

import type.*;
import semantics.*;

public abstract class Statement {
    public abstract Type accept (TypeVisitor v) throws SemanticException;
    public abstract void accept (Visitor v);
}
