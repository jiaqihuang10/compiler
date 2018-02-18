package ast;

<<<<<<< HEAD
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
=======
public class Identifier extends Expression {
    String name;

    public Identifier (String n) {
        name = n;
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
    }

    public String toString() {
        return name;
    }

<<<<<<< HEAD
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
=======
    public void accept (Visitor v) {
        v.visit(this);
    }
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
