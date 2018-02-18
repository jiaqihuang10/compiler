package ast;

import java.util.Vector;
import semantics.*;
import type.*;

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

    public Type accept(TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
}
