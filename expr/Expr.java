package expr;

import logoCompiler.lexer.*;
import logoCompiler.parser.Parser;
import operatortokens.OperatorToken;
import token.DigitToken;
import token.IdentToken;
import token.NumberToken;
import token.Token;

/*
 * expr:
 *   primary-expr 
 *   binary-expr 
 */
public abstract class Expr {

		/*We need to differentiate between binary operations and primary expressions*/
		/* 
		 * primary-expr
		 * binary-expr ; 
		 */
	  public static Expr parse() {
		  	return fraserHanson(1);
	  }

	  //Binary Expressions precedence handler from Fraser and Hanson C Compiler book
	  private static Expr fraserHanson(int k) {
		  int   i;
		  Expr  left;
		  OperatorToken oper;
		  Expr  right;
		  left = PrimaryExpr.parse();
		  
		  for (i = Parser.t.precedence(); i >= k; i--) {
		    while (Parser.t.precedence() == i) {
		      oper = (OperatorToken) Parser.t; 
		      Parser.t = Lexer.lex();
		      right = fraserHanson(i+1);
		      left  = new BinaryExpr(left, oper, right); 
		    }
		  }
		  return left;
	  }

	 
  public abstract void codegen();
}
