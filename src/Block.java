package ast;

import java.util.Vector;

public class Block extends ASTNode {
    StatementList l;

    public Block (StatementList s) {
        l = s;
    }

<<<<<<< HEAD
    public StatementList getStatementList() {
        return l;
    }
=======
    /*public void addElement (Statement stm) {
        slist.addElement(stm);
    }*/
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858

    public int size() {
        return l.size();
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
}
