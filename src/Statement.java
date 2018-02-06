package ast;

public abstract class Statement {
    public abstract void accept (Visitor v);
}
