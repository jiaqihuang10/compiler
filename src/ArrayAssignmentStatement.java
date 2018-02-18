package ast;

<<<<<<< HEAD
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
=======
public class ArrayAssignmentStatement extends Statement {
	Identifier id;
	Expression expr1;
    Expression expr2;

	public ArrayAssignmentStatement (Identifier i, Expression e1, Expression e2) {
		id = i;
		expr1 = e1;
        expr2 = e2;
	}

	public void accept (Visitor v) {
		v.visit(this);
	}
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
