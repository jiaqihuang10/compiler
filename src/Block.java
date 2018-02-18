package ast;

import java.util.Vector;

public class Block extends ASTNode {
    StatementList l;

    public Block (StatementList s) {
        l = s;
    }

    public StatementList getStatementList() {
        return l;
    }

    public int size() {
        return l.size();
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
}
