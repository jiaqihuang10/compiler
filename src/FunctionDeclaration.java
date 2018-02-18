<<<<<<< HEAD
package ast;

import type.*;
import semantics.*;

public class FunctionDeclaration extends ASTNode {
     TypeNode returnType;
     Identifier funcName;
     ParameterList pl;
=======

package ast;

public class FunctionDeclaration extends ASTNode {
    TypeNode returnType;
    Identifier funcName;
    ParameterList pl;
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858

    //constructor
    public FunctionDeclaration(TypeNode t, Identifier i, ParameterList p) {
        returnType = t;
        funcName = i;
        pl = p;
    }

<<<<<<< HEAD
    public Identifier getFuncId() {
        return funcName;
    }

    public TypeNode getReturnType() {
        return returnType;
    }

    public int getParaSize() {
        return pl.size();
    }

    public ParameterList getParaList() {
        return pl;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) throws SemanticException{
        return v.visit(this);
    }
=======
    public void accept(Visitor v) {
        v.visit(this);
    }
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
