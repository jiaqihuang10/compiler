package ast;

import type.*;
import semantics.*;

public class ArrayReferenceExpression extends Expression {
    Expression expr;
    IdentifierReference id;

    public ArrayReferenceExpression (IdentifierReference i, Expression e) {
        id = i;
        expr = e;
    }

    public void accept (Visitor v) {
        v.visit(this);
    }

    public IdentifierReference getId() {
        return id;
    }

    public Expression getExpr() {
        return expr;
    }

    public int getLine() {
        return expr.getLine();
    }

    public int getOffset() {
        return expr.getOffset();
    }

    public Type accept(TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
}
