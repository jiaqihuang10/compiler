package ast;

import environment.*;
import semantics.*;
import type.*;

public class AddExpression extends Expression {
    Expression expr1;
    Expression expr2;
    int line;
    int offset;

    public AddExpression (Expression e1, Expression e2, int l, int o) {
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
    }

    public void accept (Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
}
