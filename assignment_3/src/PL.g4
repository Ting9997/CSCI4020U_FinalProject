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

ifelse returns [Expr expression]
    : 'if' '(' condition=express ')'  '{' { List<Expr> statements1 = new ArrayList<Expr>(); } (s1=statement { statements1.add($s1.expression); } )* '}' 'else' '{' { List<Expr> statements2 = new ArrayList<Expr>(); } (s2=statement { statements2.add($s2.expression); } )* '}' { $expression = new Ifelse($condition.expression, new Block(statements1), new Block(statements2)); }
    ;

declareFunc returns [Expr expression]
    : { List<String> parameters = new ArrayList<String>();}
    'function' id=ID '(' str1=ID { parameters.add($str1.text); } (',' str2=ID  { parameters.add($str2.text); })* ')' '{' { List<Expr> statements = new ArrayList<Expr>(); } (s=statement { statements.add($s.expression); } )* '}' { $expression = new Declare($id.text, parameters , new Block(statements)); }
    ;

loop returns [Expr expression]
    : { List<Expr> statements = new ArrayList<Expr>();}
    'for(' id=ID 'in' num1=express '..' num2=express ')' '{' (s=statement { statements.add($s.expression); })* '}' { $expression = new Loop($id.text, $num1.expression, $num2.expression, new Block(statements)); }
    ;
    
statement returns [Expr expression]
    : assign = assignment ';'? { $expression = $assign.expression; }
    | forloop = loop { $expression = $forloop.expression; }
    | declare = declareFunc { $expression = $declare.expression; }
    | conditional = ifelse { $expression = $conditional.expression; }
    | e=express ';'? { $expression = $e.expression; }
    ;

assignment returns [Expr expression]
    : 'let'? id=ID '=' e=express { $expression = new Assignment($id.text, $e.expression); }
    ;

funCall returns [Expr expression]
    : 'print(' e=express ')' ';'? { $expression = new Print($e.expression); }
    | id=ID '(' arguments=argList ')' { $expression = new Invoke($id.text, $arguments.args); }
    ;

argList returns [List<Expr> args]
    : { List<Expr> arguments = new ArrayList<Expr>(); }
    e1=express { arguments.add($e1.expression); } (',' e2=express { arguments.add($e2.expression); })* { $args = arguments; }
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
    | num=FLOAT { $v = new FloatLiteral($num.text); } // Float
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
NUMBER : [0-9]+ ('.' [0-9]+)? ;
FLOAT : [0-9]+ '.' [0-9]+ ;
ID : [_a-zA-Z0-9]+ ;
INT : [0-9]+ ;
WS : [ \t\n\r]+ -> skip ;

// Ignore comments
COMMENT : '/*' .*? '*/' -> skip;