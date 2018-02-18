package ast;

<<<<<<< HEAD
import semantics.*;
import type.*;

public class WhileStatement extends Statement {
    Expression expr;
    Block blk;
    int line;
    int offset;

    public WhileStatement (Expression e, Block b, int l, int o) {
        expr = e;
        blk = b;
        line = l;
        offset = o;
    }

    public Expression getCondExpr() {
        return expr;
    }

    public Block getBlock() {
        return blk;
    }

    public int getLine() {
        return line;
    }

    public int getOffset() {
        return offset;
=======
public class WhileStatement extends Statement {
    Expression expr;
    Block blk;

    public WhileStatement (Expression e, Block b) {
        expr = e;
        blk = b;
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
<<<<<<< HEAD

    public Type accept (TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
