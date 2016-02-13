package logoCompiler.parser;
import  logoCompiler.lexer.*;
import stmts.Stmts;
import token.IdentToken;
import token.ParenthesisToken;
import token.Token.Symbol_t;


/*
 * proc:
 *   "PROC" ident '(' ident ')' stmts 
 */
public final class Proc {
  String name;
  String arg;
  Stmts stmts;

  public Proc(String name, String arg, Stmts stmts) {
    this.name  = name;
    this.arg   = arg;
    this.stmts = stmts;
  }

	/**
	 * Need to add cases for saving the arg and stmnts
	 * 
	 * This function reads the tokens to capture a PROC
	 * 
	 */
  
  	/*
  	 * "PROC" ident '(' ident ')' stmts ; 
  	 */
  public static Proc parse() {
    String   name  = "";
    String   arg   = "";
    
    Parser.t = Lexer.lex();

    if (Parser.t instanceof IdentToken) {
      name = ((IdentToken) Parser.t).getAttr();
      Parser.t = Lexer.lex();
    } else {
      //error?
    }
    if (Parser.t instanceof ParenthesisToken && Parser.t.getSymbol() == Symbol_t.LBrace) {
    	
      Parser.t = Lexer.lex();
    } else {
      //error?
    }
    
    if (Parser.t instanceof IdentToken) {
        arg = ((IdentToken) Parser.t).getAttr();
        Parser.t = Lexer.lex();
     } else {
        //error?
     }
    
    if (Parser.t instanceof ParenthesisToken && Parser.t.getSymbol() == Symbol_t.RBrace) {
    	
        Parser.t = Lexer.lex();
    } else {
        //error?
    }
    
    
    
    //...
    
    return new Proc(name, arg, Stmts.parse());
  }

  /*We don't seem to have any code to deal with the arguments*/
  public void codegen() {
    System.out.print("/");
    System.out.print(name);
    System.out.println(" {");
    stmts.codegen();
    System.out.println("} def");
  }
}
