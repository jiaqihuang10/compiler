package ast;

import semantics.*;
import type.*;

public class AssignmentStatement extends Statement {
	 IdentifierReference id;
	 Expression expr;

	public AssignmentStatement (IdentifierReference i, Expression e) {
		id = i;
		expr = e;
	}

	public void accept (Visitor v) {
		v.visit(this);
	}

    public IdentifierReference getIdr() {
        return id;
    }

    public Expression getExpr() {
        return expr;
    }

    public Type accept (TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
}
