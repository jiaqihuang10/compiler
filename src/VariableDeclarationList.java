package ast;

import java.util.Vector;

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
}
