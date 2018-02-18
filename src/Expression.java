package ast;

<<<<<<< HEAD
import semantics.*;
import type.*;

public abstract class Expression extends ASTNode {
    public abstract Type accept (TypeVisitor v) throws SemanticException;
    public abstract void accept (Visitor v);
    public abstract int getLine();
    public abstract int getOffset();
=======
public abstract class Expression extends ASTNode {
    public abstract void accept (Visitor v);
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
