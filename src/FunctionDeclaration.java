
package ast;

public class FunctionDeclaration extends ASTNode {
    TypeNode returnType;
    Identifier funcName;
    ParameterList pl;

    //constructor
    public FunctionDeclaration(TypeNode t, Identifier i, ParameterList p) {
        returnType = t;
        funcName = i;
        pl = p;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
