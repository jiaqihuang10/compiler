package ast;

import type.*;
import semantics.*;

public class ParenExpression extends Expression {
    Expression expr;


    public ParenExpression (Expression e) {
        expr = e;
    }

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

}
