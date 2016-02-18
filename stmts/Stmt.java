package stmts;

import exceptions.ParsingException;
import helper.ParsingHelper;
import logoCompiler.parser.Parser;
import token.IdentToken;
import token.KeywordToken;

/**
 * Abstract class to define the basis for what needs to be included in a 'stmt' type object.
 */
public abstract class Stmt {
	
	
	/* We need some attributes to hold so that codegen can be used, 
	 * see Proc.java, However it would be a silly idea for them to be in this
	 * super class */

	public Stmt() {
		
	}	
	
	/*
	 * "FORWARD" expr
	 * "LEFT" expr
	 * "RIGHT" expr
	 * "IF" expr "THEN" stmts "ELSE" stmts "ENDIF"
	 * 	ident '(' expr ')' 
	 *
	 * Note, the rule for any child classes here is that the caller performs the first call to lex()
	 *
	 * Another note, all Stmt classes will use the parse function to return a Stmt object
	 */

    /**
     * Method to allow the class to be able to parse itself and give proper output.
     * @return The properly parsed statement.
     * @throws ParsingException
     */
	public static Stmt parse() throws ParsingException {
		/*
		 * Note that the Parser.t stores the expression token at this point
		 */
		switch (Parser.t.getAttr()) {
		case "FORWARD":
			return ForwardStmt.parse();
		case "LEFT":
			return LeftStmt.parse();
		case "RIGHT":
			return RightStmt.parse();
		}
		
		
		/*
		 * IF THEN ELSE ENDIF
		 * */
		if (ParsingHelper.expected(KeywordToken.class, "IF", false)) {
			return ConditionalStmt.parse();
		} 
		
		
		/*
		 * ident '(' expr ')' 
		 */
		else if (ParsingHelper.expected(IdentToken.class, false)) {
			return FunctionCallStmt.parse();
		} else {
			return null;
		}
		
		
		
		
	}

    /**
     * Method to enforce the inclusion of their own parsing/codegen methods.
     */
	public abstract void codegen();
}
