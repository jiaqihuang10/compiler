package ast;

<<<<<<< HEAD
import semantics.*;
import type.*;

public class FormalParameter extends ASTNode {
    TypeNode tn;
    Identifier id;

=======
public class FormalParameter extends ASTNode {
    //the first parameter in function declarations
    TypeNode tn;
    Identifier id;

    //constructor
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
    public FormalParameter (TypeNode t, Identifier i) {
        tn = t;
        id = i;
    }

<<<<<<< HEAD
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
=======
    public void accept(Visitor v) {
        v.visit(this);
    }
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
