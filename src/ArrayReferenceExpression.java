package ast;

<<<<<<< HEAD
import type.*;
import semantics.*;

public class ArrayReferenceExpression extends Expression {
    Expression expr;
    IdentifierReference id;

    public ArrayReferenceExpression (IdentifierReference i, Expression e) {
=======
public class ArrayReferenceExpression extends Expression {
    Expression expr;
    Identifier id;

    public ArrayReferenceExpression (Identifier i, Expression e) {
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
        id = i;
        expr = e;
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
<<<<<<< HEAD

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
=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
