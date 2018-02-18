package ast;

<<<<<<< HEAD
import type.*;
import semantics.*;

public class ParenExpression extends Expression {
    Expression expr;


=======
public class ParenExpression extends Expression {
    Expression expr;

>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
    public ParenExpression (Expression e) {
        expr = e;
    }

<<<<<<< HEAD
    public Expression getExpr() {
        return expr;
    }
    
    public int getLine(){
        return expr.getLine();
    }

    public int getOffset(){
        return expr.getOffset();
    }

    public void accept (Visitor v) {
        v.visit(this);
    }

    public Type accept (TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }

=======
    public void accept (Visitor v) {
        v.visit(this);
    }
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
