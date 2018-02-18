package ast;

<<<<<<< HEAD
import semantics.*;
import type.*;

=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
public class ExpressionStatement extends Statement {
    Expression expr;

    public ExpressionStatement (Expression e) {
        expr = e;
    }

<<<<<<< HEAD
    
    public Expression getExpr(){
        return expr;
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
