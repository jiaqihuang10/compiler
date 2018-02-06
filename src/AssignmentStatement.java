package ast;

public class AssignmentStatement extends Statement {
	Identifier id;
	Expression expr;

	public AssignmentStatement (Identifier i, Expression e) {
		id = i;
		expr = e;
	}

	public void accept (Visitor v) {
		v.visit(this);
	}
}
