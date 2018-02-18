package ast;

<<<<<<< HEAD
import type.*;
import semantics.*;

public abstract class Statement {
    public abstract Type accept (TypeVisitor v) throws SemanticException;
=======
public abstract class Statement {
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
    public abstract void accept (Visitor v);
}
