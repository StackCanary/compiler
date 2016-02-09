package logoCompiler.parser;

import logoCompiler.lexer.*;
import operatortokens.OperatorToken;

/*
 * expr:
 *   primary-expr 
 *   binary-expr 
 */
public abstract class Expr {

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
		  
		  for (i = OldParser.t.precedence(); i >= k; i--) {
		    while (OldParser.t.precedence() == i) {
		      oper = (OperatorToken) OldParser.t; 
		      OldParser.t = Lexer.lex();
		      right = fraserHanson(i+1);
		      left  = new BinaryExpr(left, oper, right); 
		    }
		  }
		  return left;
	  }

  public abstract void codegen();
}
