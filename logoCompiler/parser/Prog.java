package logoCompiler.parser;
import  logoCompiler.lexer.*;
import sun.security.pkcs.ParsingException;
import token.EOIToken;
import token.PROCToken;

import java.util.*;
/*
 * prog:
 *   { proc }
 */
public class Prog {
	
	List<Proc> procs;	
	
	public Prog(List<Proc> procs) {
		this.procs = procs;
	}
	
	/**
	 * This function parses a program and returns a Prog object
	 * @return A Prog object
	 * @throws ParsingException
	 */
  public static Prog parse() throws ParsingException {
		/*An ArrayList of Proc objects*/
	 List<Proc> procs = new ArrayList<Proc>();
		/*Procs can parse themselves*/
	 procs.add(Proc.parse());

    while (Parser.t instanceof PROCToken) {
   	    procs.add(Proc.parse());
    }
    
    if (Parser.t instanceof EOIToken) {
      Parser.t = Lexer.lex();
    } else {
    	
    } 
    return new Prog(procs);
  }

  /**
   * Generates the code for the entire program
   */
  public void codegen() {
	ListIterator<Proc> li = procs.listIterator();
    while (li.hasNext()) {
        li.next().codegen();
     } 
  } 
}
