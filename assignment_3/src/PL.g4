grammar PL;

@header {
import backend.*;
}

@members {
}

program returns [Expr expr]
    : { List<Expr> statements = new ArrayList<Expr>();}
    (s=statement { statements.add($s.expression); })+ EOF { $expr = new Block(statements); }
;    


declareFunc returns [Expr expression]
    : 'function' id=ID '(' args=funArgs ')' ':' type=ID {String returnType = $type.text;} '{' eList=stmntList '}' 
    { $expression = new Declare($id.text, $args.argList , new Block($eList.exprList), returnType); }
;

initialize returns [Expr expression]
    : typeName=ID varName=ID '=' express { $expression = new Initialize($typeName.text, $varName.text, $express.expression);}
;

assignment returns [Expr expression]
    : id=ID '=' e=express { $expression = new Assignment($id.text, $e.expression); }
;

funCall returns [Expr expression]
    : 'print(' e=express ')' ';'? { $expression = new Print($e.expression); }
    | id=ID '(' argList=stmntList ')' { $expression = new Invoke($id.text, $argList.exprList); }
;

ifelse returns [Expr expression]
    : 'if' '(' condition=express ')' '{' eList1=stmntList '}' 'else' '{' eList2=stmntList '}' 
    {$expression = new Ifelse($condition.expression, new Block($eList1.exprList), new Block($eList2.exprList));}
;

forLoop returns [Expr expression]
    : 'for(' id=ID 'in' num1=express '..' num2=express ')' '{' eList=stmntList '}' 
    { $expression = new Loop($id.text, $num1.expression, $num2.expression, new Block($eList.exprList)); }
;

whileLoop returns [Expr expression]
    : 'while(' condition=express ')' '{' eList=stmntList '}' 
    { $expression = new While($condition.expression, new Block($eList.exprList)); }
;

stmntList returns [List<Expr> exprList] : 
    {List<Expr> statements = new ArrayList<Expr>();}
    ( ','? statement {statements.add($statement.expression);} )+  { $exprList = statements;}
;

funArgs returns [List<FuncArg> argList] : 
    {List<FuncArg> parameters = new ArrayList<FuncArg>();}
    (','? typeName=ID str=ID { parameters.add(new FuncArg($typeName.text, $str.text)); })+  { $argList = parameters;}
;

statement returns [Expr expression]
    : initialize ';'? { $expression = $initialize.expression; }
    | assign = assignment ';'? { $expression = $assign.expression; }
    | forloop = forLoop { $expression = $forloop.expression; }
    | whileloop = whileLoop { $expression = $whileloop.expression; }
    | declare = declareFunc { $expression = $declare.expression; }
    | conditional = ifelse { $expression = $conditional.expression; }
    | e=express ';'? { $expression = $e.expression; }
;

express returns [Expr expression]
    : val=value { $expression = $val.v; }
    | func=funCall { $expression = $func.expression; }
    | left=express operator=arithmetic right=express { $expression = new Arithmetics($operator.op, $left.expression, $right.expression); }
    | left=express com=comparator right=express { $expression = new Compare($com.co, $left.expression, $right.expression); }
    | '(' e=express ')' { $expression=$e.expression; }
    | id=ID { $expression = new Deref($id.text); } 
;

value returns [Expr v]
    : str=STRING { $v = new StringLiteral($str.text); } // string
    | num=NUMBER { $v = new IntLiteral($num.text); } // number
    | '-' num=NUMBER { $v = new IntLiteral("-" + $num.text); } // negative number
    | num=DOUBLE { $v = new DoubleLiteral($num.text); } // Float
;



arithmetic returns [Operator op]
    : ('+' | '++') { $op = Operator.Add; } 
    | '-' { $op = Operator.Sub; }
    | '*' { $op = Operator.Mul; }
    | '/' { $op = Operator.Div; }
;
    
comparator returns [Comparator co]
    : '<' { $co = Comparator.LT; } 
    | '<=' { $co = Comparator.LE; } 
    | '>' { $co = Comparator.GT; } 
    | '>=' { $co = Comparator.GE; } 
    | '==' { $co = Comparator.EQ; } 
    | '!=' { $co = Comparator.NE; } 
;

// Lexer Rules
STRING : '"' (~["\\])* '"' ;
NUMBER : [0-9]+ ;
DOUBLE : [0-9]+ '.' [0-9]+ ;
ID : [_a-zA-Z0-9]+ ;
INT : [0-9]+ ;
WS : [ \t\n\r]+ -> skip ;

// Ignore comments
COMMENT : '/*' .*? '*/' -> skip;