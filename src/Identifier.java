package ast;

import semantics.*;
import type.*;

public class Identifier extends Expression {
    public String name;
    int line;
    int offset;

    public Identifier (String n, int l, int o) {
        name = n;
        line = l;
        offset = o;
    }

    public String toString() {
        return name;
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
