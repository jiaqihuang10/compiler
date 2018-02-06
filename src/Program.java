package ast;

import java.util.Vector;

public class Program extends ASTNode {
    public Vector flist;

    public Program() {
        flist = new Vector();
    }

    //add function to the function list
    public void addElement(Function f) {
        flist.add(f);
    }

    public int size() {
        return flist.size();
    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
