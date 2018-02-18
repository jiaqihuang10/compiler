package ast;

<<<<<<< HEAD
import semantics.*;
import type.*;

=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
public class Function extends ASTNode {
    public FunctionDeclaration funcDecl;
    public FunctionBody funcBody;

    public Function(FunctionDeclaration fd, FunctionBody fb) {
        funcDecl = fd;
        funcBody = fb;
    }

<<<<<<< HEAD
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
=======
    public void accept(Visitor v) {
        v.visit(this);
    }
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
