package evaluacionfinal; 
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n]+

%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn, null);
    }
%}
%%
{espacio} {/* Ignore */}

"if"     {return symbol(sym.If, yytext());}
"true"   {return symbol(sym.True, yytext());}
"false"  {return symbol(sym.False, yytext());}
"=="     {return symbol(sym.IgualIgual, yytext());}
"<="     {return symbol(sym.MenorIgual, yytext());}
">="     {return symbol(sym.MayorIgual, yytext());}
"<"      {return symbol(sym.Menor, yytext());}
">"      {return symbol(sym.Mayor, yytext());}
"("      {return symbol(sym.Parentesis_a, yytext());}
")"      {return symbol(sym.Parentesis_c, yytext());}
";"      {return symbol(sym.P_coma, yytext());}
{L}({L}|{D})*  {return symbol(sym.Identificador, yytext());}
{D}+           {return symbol(sym.Numero, yytext());}
. {return symbol(sym.ERROR, yytext());}

