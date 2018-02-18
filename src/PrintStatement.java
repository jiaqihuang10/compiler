package ast;

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
    }

    public void accept (Visitor v) {
        v.visit(this);
    }

    public Expression getPrintExpr() {
        return expr;
    }

    public Type accept (TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
}
