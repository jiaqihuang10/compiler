package ast;

public class FormalParameter extends ASTNode {
    //the first parameter in function declarations
    TypeNode tn;
    Identifier id;

    //constructor
    public FormalParameter (TypeNode t, Identifier i) {
        tn = t;
        id = i;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
