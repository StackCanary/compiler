package logoCompiler.parser;
import  logoCompiler.lexer.*;
import stmts.Stmts;
import exceptions.ParsingException;
import helper.ParsingHelper;
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
	 * @throws ParsingException 
	 * @throws sun.security.pkcs.ParsingException 
	 * 
	 */
  
  	/*
  	 * "PROC" ident '(' ident ')' stmts ; 
  	 */
  public static Proc parse() throws ParsingException, sun.security.pkcs.ParsingException {
    String   name  = "";
    String   arg   = "";
    
    Parser.t = Lexer.lex();

    if (ParsingHelper.expected(IdentToken.class, true)) {
    	name = ((IdentToken) Parser.t).getAttr();
    	Parser.t = Lexer.lex();
    } 
    
    if (ParsingHelper.expected(ParenthesisToken.class, Symbol_t.LParen, true)) {
      Parser.t = Lexer.lex();
    } 
    
    if (ParsingHelper.expected(IdentToken.class, true)) {
        arg = ((IdentToken) Parser.t).getAttr();
        Parser.t = Lexer.lex();
    } 
    
    if (ParsingHelper.expected(ParenthesisToken.class, Symbol_t.RParen, true)) {
        Parser.t = Lexer.lex();
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
