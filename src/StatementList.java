package ast;

import java.util.Vector;
<<<<<<< HEAD
import semantics.*;
import type.*;
=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858

public class StatementList extends ASTNode {
    public Vector slist;

    //constructor
    public StatementList() {
        slist = new Vector();
    }

    public void addElement(Statement stm) {
        slist.addElement(stm);
    }

    public int size() {
        return slist.size();
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
