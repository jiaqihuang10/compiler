package ast;

public class VariableDeclaration extends ASTNode {
    Identifier id;
    TypeNode tn;

    //constructor
    public VariableDeclaration(TypeNode t, Identifier i) {
        id = i;
        tn = t;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
