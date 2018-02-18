package ast;

<<<<<<< HEAD
import semantics.*;
import type.*;

public class AssignmentStatement extends Statement {
	 IdentifierReference id;
	 Expression expr;

	public AssignmentStatement (IdentifierReference i, Expression e) {
=======
public class AssignmentStatement extends Statement {
	Identifier id;
	Expression expr;

	public AssignmentStatement (Identifier i, Expression e) {
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
		id = i;
		expr = e;
	}

	public void accept (Visitor v) {
		v.visit(this);
	}
<<<<<<< HEAD

    public IdentifierReference getIdr() {
        return id;
    }

    public Expression getExpr() {
        return expr;
    }

    public Type accept (TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
