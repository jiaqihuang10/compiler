package ast;

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
}
