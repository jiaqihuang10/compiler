package type;

import ast.*;

public class ArrayType extends Type {
    TypeNode t;
    IntegerLiteral n;

    public ArrayType(TypeNode tt, Expression nn) {
        t = tt;
        n = (IntegerLiteral)nn;
    }
    public String toString() {
        String str = t.getType() + "[" + Integer.toString(n.getVal()) + "]";
        return str;
    }

}
