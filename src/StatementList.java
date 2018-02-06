package ast;

import java.util.Vector;

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
}
