package stmts;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import exceptions.ParsingException;
import logoCompiler.lexer.Lexer;
import logoCompiler.parser.Parser;
import token.IdentToken;

public class Stmts {

	List<Stmt> stmnts;
	
	public Stmts() {
		stmnts = new ArrayList<Stmt>();
	}
 	
	
	/*This returns a Stmts object which is used in Proc.java*/
	
	/*
	 * { stmnt }
	 */
	public static Stmts parse() throws ParsingException {
//		Parser.t = Lexer.lex();
		Stmts stmnts = new Stmts();
		
		Stmt statement;
		
		/* Need a better test for completion */
		while((statement = Stmt.parse()) != null) {
			stmnts.stmnts.add(statement);
		}
		
		return stmnts;
		
	}
	
	/*This method returns the compiled code for all the statements*/
	/*This method is called by Proc*/
	public void codegen() {
		ListIterator<Stmt> li = stmnts.listIterator();
	    while (li.hasNext()) {
	        li.next().codegen();
	     } 
	  } 
}
