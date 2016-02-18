package logoCompiler.parser;

import logoCompiler.lexer.*;
import token.EOIToken;
import token.PROCToken;
import java.util.*;

import exceptions.ParsingException;
import helper.ParsingHelper;

/*
 * Follows this syntax
 * prog:
 *   { proc }
 */

/**
 * The class used to represent the encompassing Prog object holding the list of Procs.
 */
public class Prog {
	
	List<Proc> procs;	

    /**
     * This constructor is used to create the overall Prog using the associated list of Procs.
     */
	public Prog(List<Proc> procs) {
		this.procs = procs;
	}


    /**
     * This method is used to parse the Prog object by itself and return a Prog object.
     * @return The Prog object containing a list of Proc objects.
     * @throws ParsingException If there is a failure in the grammar of the parse procedure.
     */
    public static Prog parse() throws ParsingException {
    /*An ArrayList of Proc objects*/
        List<Proc> procs = new ArrayList<Proc>();
        /*Procs can parse themselves*/
        procs.add(Proc.parse());

        while (ParsingHelper.expected(PROCToken.class, false)) {
            procs.add(Proc.parse());
        }
        
        if (ParsingHelper.expected(EOIToken.class, true)) {
        	
        } else {
        	
        }
        
        return new Prog(procs);
    }

    /**
     * Causes the Procs in the Prog list to parse and codegen for themselves.
     */
    public void codegen() {
        ListIterator<Proc> li = procs.listIterator();
        while (li.hasNext()) {
            li.next().codegen();
        }
    }

}
