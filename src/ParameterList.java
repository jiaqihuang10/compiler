package ast;

import java.util.Vector;
<<<<<<< HEAD
import semantics.*;
import type.*;
=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858

public class ParameterList extends ASTNode {
    //more parameters in function declarations
    public Vector paralist;

    public ParameterList() {
        paralist = new Vector();
    }
    public void addElement(FormalParameter para) {
        paralist.addElement(para);
    }

    public int size() {
        return paralist.size();
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

<<<<<<< HEAD
    public Type accept(TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
