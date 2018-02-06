package ast;

public class IfStatement extends Statement {
     Expression expr;
     Block blk1;
     Block blk2;


    public IfStatement (Expression e, Block b) {
        expr = e;
        blk1 = b;
        blk2 = null;
    }

    public void setB2 (Block b) {
        blk2 = b;
    }
    public void accept (Visitor v) {
        v.visit(this);
    }
}
