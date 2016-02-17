package stmts;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import exceptions.ParsingException;

/**
 * This class is used to store a list of the individual stmt objects.
 */
public class Stmts {

	List<Stmt> stmnts;

    /**
     * constructor to create an ArrayList of Stmt for this objects content
     */
	public Stmts() {
		stmnts = new ArrayList<Stmt>();
	}

	/*This returns a Stmts object which is used in Proc.java*/
	
	/*
	 * { stmnt }
	 */

    /**
     * Allows the Stmts object to correctly parse itself.
     * @return the parsed Stmts object
     * @throws ParsingException
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

    /**
     * 	This method returns the compiled code for all the statements
	 *  This method is called by Proc
     */
	public void codegen() {
		ListIterator<Stmt> li = stmnts.listIterator();
	    while (li.hasNext()) {
	        li.next().codegen();
	     } 
	  } 
}
