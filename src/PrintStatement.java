package ast;

<<<<<<< HEAD
import semantics.*;
import type.*;

public class PrintStatement extends Statement {
    Expression expr;
    int line;
    int offset;

    public PrintStatement (Expression e, int l, int o) {
        expr = e;
        line = l;
        offset = o;
    }

    public int getLine() {
        return line;
    }

    public int getOffset() {
        return offset;
=======
public class PrintStatement extends Statement {
    Expression expr;

    public PrintStatement (Expression e) {
        expr = e;
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
<<<<<<< HEAD

    public Expression getPrintExpr() {
        return expr;
    }

    public Type accept (TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
