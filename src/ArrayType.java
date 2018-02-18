package type;

import ast.*;

public class ArrayType extends Type {
    TypeNode t;
    IntegerLiteral n;

<<<<<<< HEAD

=======
>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
    public ArrayType(TypeNode tt, Expression nn) {
        t = tt;
        n = (IntegerLiteral)nn;
    }
<<<<<<< HEAD

    public Type getTypeOfArray() {
        return t.type;
    }
    
    public String toString() {
        String str = t.type + "[" + Integer.toString(n.getVal()) + "]";
        return str;
    }
=======
    public String toString() {
        String str = t.getType() + "[" + Integer.toString(n.getVal()) + "]";
        return str;
    }

>>>>>>> daaabcc7c0d1bdd3a143a14a0ce8f99392224858
}
