package stmts;

import expr.Expr;
import helper.ParsingHelper;
import logoCompiler.Output;
import logoCompiler.lexer.Lexer;
import logoCompiler.parser.Parser;
import token.IdentToken;
import token.ParenthesisToken;
import token.Token.Symbol_t;

/**
 * This class represents the Forward Statement type.
 */
public class FunctionCallStmt extends Stmt {
	private String name;
	private Expr expr;

	/*
	 * ident '(' expr ')' 
	 */

    /**
     * Constructor taking in the name of the function to call and an expression
     * to create a statement
     * @param name The name of a function that is to be called
     * @param expr The expression to be used with that function
     */
    public FunctionCallStmt(String name, Expr expr) {
		this.name = name;
		this.expr = expr;
	}

	/*
	 * This function will return a FunctionCallStmt
	 */

    /**
     * Method to allow the class to be able to parse itself and give proper output.
     * @return The properly parsed statement.
     */
	public static Stmt parse() {
		//Parser.t = Lexer.lex();
		String name = null;
		Expr expr = null;


		if (ParsingHelper.expected(IdentToken.class, true)) {
			name = ((IdentToken) Parser.t).getAttr();
			Parser.t = Lexer.lex();
		} 

		ParsingHelper.expected(ParenthesisToken.class, Symbol_t.LParen, true);

		Parser.t = Lexer.lex();
		expr = Expr.parse();

		ParsingHelper.expected(ParenthesisToken.class, Symbol_t.RParen, true);
		
		Parser.t = Lexer.lex();
		
		return new FunctionCallStmt(name, expr);

	}

    /**
     * Method to provide output to the destination file.
     */
	@Override
	public void codegen() {
		Output.writeToFile("Arg");
		expr.codegen();
		Output.writeToFile(name);
		Output.writeToFile("/Arg exch def");
	}


}
