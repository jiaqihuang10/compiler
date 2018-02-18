package ast;

<<<<<<< HEAD
import type.*;
import semantics.*;

=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
public class VariableDeclaration extends ASTNode {
    Identifier id;
    TypeNode tn;

    //constructor
    public VariableDeclaration(TypeNode t, Identifier i) {
        id = i;
        tn = t;
    }

<<<<<<< HEAD
    public Identifier getVarId() {
        return id;
    }

    public TypeNode getVarType() {
        return tn;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
=======
    public void accept(Visitor v) {
        v.visit(this);
    }
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
