package ast;

import semantics.*;
import type.*;

public class ReturnStatement extends Statement {
    Expression expr;

    public ReturnStatement (Expression e) {
        expr = e;
    }

    public Expression getExpr() {
        return expr;
    }
    
    public void accept (Visitor v) {
        v.visit(this);
    }

    public Type accept (TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
}
