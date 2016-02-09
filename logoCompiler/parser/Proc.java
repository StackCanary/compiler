package logoCompiler.parser;
import  logoCompiler.lexer.*;
import token.IdentToken;
import token.LParenToken;
import token.ParenthesisToken;


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
  public static Proc parse() {
    String   name  = "";
    String   arg   = "";

    OldParser.t = Lexer.lex();

    if (OldParser.t instanceof IdentToken) {
      name = ((IdentToken) OldParser.t).getAttr();
      OldParser.t = Lexer.lex();
    } else {
      //error?
    }
    if (OldParser.t instanceof ParenthesisToken) {
    	
      OldParser.t = Lexer.lex();
    } else {
      //error?
    }
    
    //...
    
    return new Proc(name, arg, stmts);
  }

  public void codegen() {
    System.out.print("/");
    System.out.print(name);
    System.out.println(" {");
    stmts.codegen();
    System.out.println("} def");
  }
}
