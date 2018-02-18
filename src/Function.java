package ast;

import semantics.*;
import type.*;

public class Function extends ASTNode {
    public FunctionDeclaration funcDecl;
    public FunctionBody funcBody;

    public Function(FunctionDeclaration fd, FunctionBody fb) {
        funcDecl = fd;
        funcBody = fb;
    }

    public String getFuncName(){
        String funcName = funcDecl.funcName.name;
        return funcName;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v)throws SemanticException{
        return v.visit(this);
    }
}
