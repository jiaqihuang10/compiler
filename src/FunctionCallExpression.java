package ast;

import java.util.Vector;
<<<<<<< HEAD
import type.*;
import semantics.*;

public class FunctionCallExpression extends Expression {
     Vector arglist;
     IdentifierReference id;

    public FunctionCallExpression() {
        arglist = new Vector();
        id = null;
    }

    public void setId(IdentifierReference i) {
        id = i;
    }

    public void addElement(Expression expr){
        arglist.addElement(expr);
    }

    public IdentifierReference getFuncId() {
        return id;
    }

    public int argSize() {
        return arglist.size();
    }

    public Vector getArglist() {
        return arglist;
    }

    public int getLine() {
        return id.getLine();
    }

    public int getOffset() {
        return id.getOffset();
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
=======

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
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
