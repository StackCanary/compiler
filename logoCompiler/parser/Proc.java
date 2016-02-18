package logoCompiler.parser;

import logoCompiler.Output;
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

/**
 * This is the class that defines the Procedure object - a key component in converting to the target language
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

  	/*
  	 * follows this syntax
  	 * "PROC" ident '(' ident ')' stmts ; 
  	 */

    /**
     * Returns a Proc object if it successfully managed to parse itself.
     * @return The parsed Proc object
     * @throws ParsingException
     * @throws sun.security.pkcs.ParsingException
     */
  public static Proc parse() throws ParsingException{
      String name = "";
      String arg = "";

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

      return new Proc(name, arg, Stmts.parse());
  }

    /*We don't seem to have any code to deal with the arguments*/

  	/**
  	 * This codegen generates the code for a procedure.
  	 * An important thing to note here is that since the 
  	 * specification suggests using only one register,
  	 * our generated code is caller save. The caller is
  	 * responsible for saving and restoring its own register
  	 * when making a function call. This was inspired by my 
  	 * knowledge of x86 asm.
  	 */

    public void codegen() {
        Output.writeToFile("/" + name + " {");

        if (!arg.equals("VOID")) {
            Output.writeToFile("/Arg exch def");
        }
        stmts.codegen();
        Output.writeToFile("} def");
    }
}
