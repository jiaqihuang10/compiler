package ast;

import java.util.Vector;
<<<<<<< HEAD
import semantics.*;
import type.*;
=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858

public class VariableDeclarationList extends ASTNode {
    public Vector vlist;

    //constructor
    public VariableDeclarationList() {
        vlist = new Vector();
    }

    public void addElement(VariableDeclaration vd) {
        vlist.addElement(vd);
    }

    public int size() {
        return vlist.size();
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
<<<<<<< HEAD

    public Type accept(TypeVisitor v) throws SemanticException{
        return v.visit(this);
    }
=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
