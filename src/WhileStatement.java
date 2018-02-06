package ast;

public class WhileStatement extends Statement {
    Expression expr;
    Block blk;

    public WhileStatement (Expression e, Block b) {
        expr = e;
        blk = b;
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
}
