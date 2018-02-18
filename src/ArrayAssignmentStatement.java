package ast;

import type.*;
import semantics.*;

public class ArrayAssignmentStatement extends Statement {
	ArrayReferenceExpression are;
    Expression expr;

	public ArrayAssignmentStatement (ArrayReferenceExpression a, Expression e) {
		are = a;
        expr = e;
	}

    public ArrayReferenceExpression getArrayReference() {
        return are;
    }

    public Expression getExpr() {
        return expr;
    }
    
	public void accept (Visitor v) {
		v.visit(this);
	}

    public Type accept(TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
}
