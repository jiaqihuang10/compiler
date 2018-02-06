grammar simple;

options {
    backtrack=true;
}

@header {
    import ast.*;
    import type.*;
}

@members
{
protected void mismatch (IntStream input, int ttype, BitSet follow)
        throws RecognitionException
{
        throw new MismatchedTokenException(ttype, input);
}
public void recoverFromMismatchedSet (IntStream input,
                                      RecognitionException e,
                                      BitSet follow)
        throws RecognitionException
{
        reportError(e);
        throw e;
}
}

@rulecatch {
        catch (RecognitionException ex) {
                reportError(ex);
                throw ex;
        }
}

program returns [Program prog]
@init
{
        prog = new Program();
}
    : (f=function { $prog.addElement(f);} )+ EOF
    ;

function returns [Function f] :
    fd=functionDecl fb=functionBody
    { f = new Function(fd,fb); }
    ;

functionDecl returns [FunctionDeclaration fd]
    :
    ct=compoundType i=id OPENPAREN pl=parameterList {fd = new FunctionDeclaration(ct,i,pl);} CLOSEPAREN
    ;

parameterList returns [ParameterList pl]
@init {
    ParameterList pa = new ParameterList();
}
@after{
    pl = pa;
}
    :
    (a=formalParameter {pa.addElement(a);})*
    ;

formalParameter returns [FormalParameter fp]
    :
    ct=compoundType i=id COMMA? {fp = new FormalParameter(ct,i);}
    ;

functionBody returns [FunctionBody fb]
@init {
    VariableDeclarationList vdl = new VariableDeclarationList();
    StatementList sl = new StatementList();
}
@after {
    fb = new FunctionBody(vdl,sl);
}
    :
    OPENCURLY (vd=varDecl {vdl.addElement(vd);}
    | stm=statement {sl.addElement(stm); })*  CLOSECURLY
	;


varDecl returns [VariableDeclaration vd]
  :
  ct=compoundType i=id { vd = new VariableDeclaration(ct,i); } SEMICOLON
  ;

compoundType returns [TypeNode tn] :
    a=arrayType {tn=a;} | a=type {tn=a;}
    ;


arrayType returns [TypeNode tn]
    : t=type OPENSQR l=integerLiteral CLOSESQR
    { Type tt = new ArrayType(t,l);
      tn = new TypeNode(tt); }
    ;


type returns [TypeNode tn]
@init{
    Type t = null;
}
@after {
    tn = new TypeNode(t);
}
    :
    BOOLEANTYPE
        { t = new BooleanType();}
    | STRINGTYPE
        { t = new StringType();}
    | CHARTYPE
        { t = new CharType();}
    | VOIDTYPE
        { t = new VoidType();}
    | INTEGERTYPE
        { t = new IntegerType();}
    | FLOATTYPE
        { t = new FloatType();}
    ;


id returns [Identifier i]
    : s=ID { i = new Identifier($s.text); }
	;

//statements
statement returns [Statement s]:
      SEMICOLON {s = new ExpressionStatement(new StringLiteral(""));}
    | a=exprStatement {s=a;}
    | a=ifStatement {s=a;}
    | a=whileStatement {s=a;}
    | a=printStatement {s=a;}
    | a=printlnStatement {s=a;}
    | a=returnStatement {s=a;}
    | a=assignmentStatement {s=a;}
    | a=arrayAssignmentStatement {s=a;}
          ;


ifStatement returns [Statement is]
@init{
     IfStatement i = null;
}
@after {
    is = i;
}
    :
    IF OPENPAREN e=expr CLOSEPAREN b1=block
    { i = new IfStatement(e,b1);}
    (ELSE b2=block  { i.setB2(b2); })?
    ;

whileStatement returns [Statement ws]
    : WHILE OPENPAREN e=expr CLOSEPAREN b=block
    { ws = new WhileStatement(e,b); }
    ;

printStatement returns [Statement ps]
    : PRINT e=expr SEMICOLON { ps = new PrintStatement(e); }
    ;


printlnStatement returns [Statement ps]
    : PRINTLN e=expr SEMICOLON { ps = new PrintlnStatement(e); }
    ;

returnStatement returns [Statement rs]
    : RETURN (e=expr)? SEMICOLON
    {rs = new ReturnStatement(e);}
  ;

exprStatement returns [Statement es]
    : e=expr SEMICOLON { es = new ExpressionStatement(e); }
  ;

assignmentStatement returns [Statement ass]
    : i=id '=' e=expr SEMICOLON { ass = new AssignmentStatement(i,e); }
  ;

arrayAssignmentStatement returns [Statement arass]
    :
    i=id OPENSQR e1=expr CLOSESQR '=' e2=expr SEMICOLON
    { arass = new ArrayAssignmentStatement(i,e1,e2); }
  ;

block returns [Block b]
@init {
    StatementList sl = new StatementList();
}
@after {
    b = new Block(sl);
}
    : OPENCURLY (s=statement {sl.addElement(s); })* CLOSECURLY
  ;

//expressions
expr returns [Expression e]
@init {
    Expression it = null;
}
@after {
    e = it;
}
    :
    e1=lessExpr { it = e1; } ('==' (e2=lessExpr { it = new EqualExpression(it,e2); }) )*
    ;

lessExpr returns [Expression e]
@init {
    Expression it = null;
}
@after {
    e = it;
}
    :
    e1=addsubExpr { it = e1; } ('<' (e2=addsubExpr { it = new LessthanExpression(it,e2); } ))*
    ;

addsubExpr returns [Expression e]
@init {
    Expression it = null;
}
@after {
    e = it;
}
    : e1=multiExpr { it = e1; }
    (op=('+'|'-') e2=multiExpr
    { if($op.text.charAt(0)=='+') {
        it = new AddExpression(it,e2);
     }
     if ($op.text.charAt(0)=='-') {
         it = new SubtractExpression(it,e2);
     }
    })*
    ;

multiExpr returns [Expression e]
@init {
    Expression it = null;
}
@after {
    e = it;
}
    : e1=atom { it = e1; } ('*' (e2=atom { it = new MultiExpression(it,e2); } ))*
    ;

atom returns [Expression e]:
      a=id { e = a;}
    | a=literal { e = a;}
    | a=functionCall { e = a;}
    | a=arrayRef { e = a;}
    | a=parenExpr { e = a;}
  ;

arrayRef returns [Expression e]
@init {
    Expression it = null;
}
@after {
    e = it;
}
    : i=id OPENSQR ee=expr CLOSESQR { it = new ArrayReferenceExpression(i,ee); }
    ;

functionCall returns [Expression e]
@init {
    FunctionCallExpression it = null;
}
@after {
    e = it;
}
    :
    i=id { it = new FunctionCallExpression();
        it.setId(i); }
        OPENPAREN (e1=expr { it.addElement(e1); }
    (COMMA e2=expr {it.addElement(e2); })*)? CLOSEPAREN
    ;

parenExpr returns [Expression e]
    : OPENPAREN ee=expr CLOSEPAREN { $e = new ParenExpression(ee);}
    ;

literal returns [Expression e]:
    a=charLiteral{e=a;} | a=stringLiteral{e=a;} | a=integerLiteral{e=a;}
    | a=floatLiteral{e=a;} | a=booleanLiteral{e=a;}
    ;

charLiteral returns [Expression l]
    : c=CHAR
    { String s = $c.text;
      l = new CharacterLiteral(s);}
    ;

stringLiteral returns  [Expression l]
    : s=STRING { l = new StringLiteral($s.text); }
    ;

integerLiteral returns [Expression l]
    : ('-')? i=INTEGER { l = new IntegerLiteral(Integer.parseInt($i.text));}
    ;

floatLiteral returns [Expression l]
    : ('-')? f=FLOAT { l = new FloatLiteral(Float.parseFloat($f.text)); }
    ;

booleanLiteral returns [Expression l]
    : b=BOOLEAN { l = new BooleanLiteral(Boolean.parseBoolean($b.text)); }
    ;

/* Lexer */
OPENPAREN : '('
  ;

CLOSEPAREN : ')'
  ;

SEMICOLON : ';'
  ;

OPENSQR : '['
  ;

CLOSESQR : ']'
  ;

OPENCURLY : '{'
  ;

CLOSECURLY : '}'
    ;

COMMA :','
  ;

IF	: 'if'
	;

WHILE : 'while'
  ;

PRINT : 'print'
  ;

PRINTLN : 'println'
  ;

RETURN : 'return'
  ;

ELSE : 'else'
	;

/* Fixme: add the other types here */
INTEGERTYPE : 'int'
	;

BOOLEANTYPE : 'boolean'
    ;

STRINGTYPE : 'string'
    ;

FLOATTYPE : 'float'
    ;

VOIDTYPE : 'void'
    ;

CHARTYPE : 'char'
    ;

BOOLEAN : 'true' | 'false'
    ;

ID	: ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
    ;

CHAR :  '\'' ('a'..'z'|'A'..'Z') '\''
    ;



INTEGER : ('0'..'9')+
    ;

STRING : '"' ('a'..'z'|'A'..'Z'|' '|'0'..'9')* '"'
    ;

FLOAT : ('0'..'9')+ '.' ('0'..'9')+
    ;


/* These two lines match whitespace and comments
 * and ignore them.
 * You want to leave these as last in the file.
 * Add new lexical rules above
 */


WS      : ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
        ;

COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n') { $channel = HIDDEN;}
        ;
