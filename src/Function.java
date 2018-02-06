package ast;

public class Function extends ASTNode {
    public FunctionDeclaration funcDecl;
    public FunctionBody funcBody;

    public Function(FunctionDeclaration fd, FunctionBody fb) {
        funcDecl = fd;
        funcBody = fb;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
