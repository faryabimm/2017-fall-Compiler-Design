grammar Dracula;

/*
 * PARSER RULES
 */

program
     :   (assign | funccall | def)*
     ;

int_s
    :   INT
    ;

name
    : NAME
    ;

double_s
    :   DOUBLE
    ;

deffunc
    :   '(' (TYPE | TYPE (',' TYPE)*) ')' '->' TYPE
    ;

defvar
    :   TYPE
    ;

def
    :   NAME '::' (defvar | deffunc)
    |   'TimeFunc' deffunc
    ;

assign
    :   NAME '=' expr
    ;

expr
    :   expr_prior3
    ;

expr_prior3
    : expr_prior2 ((PLUS | MINUS) expr_prior3)*
    ;

expr_prior2
    :   expr_prior1 ((MULTIPLY | DIVIDE) expr_prior2)*
    ;


expr_prior1
    :   int_s | name | double_s
    | '(' expr ')'
    | funccall
    ;

funccall
    :   ONE
    |   GIVE '(' arg ')'
    |   NAME '(' args ')'
    |   MKDATE '(' arg ',' arg ')'
    |   FUNCOP '(' arg ',' arg ')'
    ;

arg
    :   expr
    ;

args
    :   arg (',' arg)*
    ;

/*
 * LEXER RULES
 */

WHITESPACE: [ \n\t\r]+ -> skip;


NAME
    :   [a-z]+ [a-z0-9]*
    ;

INT
    :   [0-9]+
    ;

DOUBLE
    :   [0-9]+ '.' [0-9]*
    ;


TYPE
    :   'Int'
    |   'Double'
    |   'Date'
    |   'Contract'
    ;


MINUS : '-';
PLUS : '+';
MULTIPLY : '*';
DIVIDE : '/';

ONE: 'one' WHITESPACE* '(' WHITESPACE* ')';
GIVE: 'give';
MKDATE: 'Mkdate';

FUNCOP
    :   'and'
    |   'or'
    |   'then'
    |   'scaleX'
    |   'scale'
    |   'truncate'
    ;