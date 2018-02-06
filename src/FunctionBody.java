package ast;

public class FunctionBody extends ASTNode {

     public VariableDeclarationList vdl;
     public StatementList stml;


    public FunctionBody(VariableDeclarationList v,StatementList s){
        vdl = v;
        stml = s;
    }

    //two kinds of nodes in functionbody : VariableDeclaration or Statement
    public void addElement(VariableDeclaration vd) {
        vdl.addElement(vd);
    }

    public void addElement (Statement s) {
        stml.addElement(s);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}
