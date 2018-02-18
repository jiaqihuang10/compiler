package ast;

import java.util.Vector;
<<<<<<< HEAD
import semantics.*;
=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858

public class Program extends ASTNode {
    public Vector flist;

    public Program() {
        flist = new Vector();
    }

    //add function to the function list
    public void addElement(Function f) {
        flist.add(f);
    }

    public int size() {
        return flist.size();
    }
    public void accept(Visitor v) {
        v.visit(this);
    }

<<<<<<< HEAD
    public void accept(TypeVisitor v) throws SemanticException {
        v.visit(this);
    }

=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
