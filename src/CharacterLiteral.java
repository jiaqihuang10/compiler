package ast;

import type.*;
import semantics.*;

public class CharacterLiteral extends Expression {

    String c;
    int line;
    int offset;

    public CharacterLiteral(String cc, int l, int o) {
        c = cc;
        line = l;
        offset = o;
    }

    public int getLine(){
        return line;
    }

    public int getOffset(){
        return offset;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) throws SemanticException {
        return v.visit(this);
    }
}
