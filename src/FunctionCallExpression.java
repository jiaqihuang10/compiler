package ast;

import java.util.Vector;

public class FunctionCallExpression extends Expression {
     Vector paralist;
     Identifier id;

    public FunctionCallExpression() {
        paralist = new Vector();
        id = null;
    }

    public void setId(Identifier i) {
        id = i;
    }
    
    public void addElement(Expression expr){
        paralist.addElement(expr);
    }

    public int size() {
        return paralist.size();
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
