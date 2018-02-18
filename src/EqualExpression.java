package ast;

<<<<<<< HEAD
import type.*;
import semantics.*;

public class EqualExpression extends Expression {
    Expression expr1;
    Expression expr2;
    int line;
    int offset;

    public EqualExpression (Expression e1, Expression e2, int l, int o) {
        expr1 = e1;
        expr2 = e2;
        line = l;
        offset = o;
    }

    public Expression getExpr1() {
        return expr1;
    }

    public Expression getExpr2() {
        return expr2;
    }
    
    public int getLine(){
        return line;
    }

    public int getOffset(){
        return offset;
=======
public class EqualExpression extends Expression {
    Expression expr1;
    Expression expr2;

    public EqualExpression (Expression e1, Expression e2) {
        expr1 = e1;
        expr2 = e2;
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
    }

    public void accept (Visitor v) {
        v.visit(this);
    }
<<<<<<< HEAD

    public Type accept(TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
