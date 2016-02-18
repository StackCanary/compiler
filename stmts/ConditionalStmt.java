package stmts;

import exceptions.ParsingException;
import expr.Expr;
import helper.ParsingHelper;
import logoCompiler.Output;
import logoCompiler.lexer.Lexer;
import logoCompiler.parser.Parser;
import token.KeywordToken;

/*
 * IF" expr "THEN" stmts "ELSE" stmts "ENDIF"
 */

/**
 * This class is used to represent a statement following an IF, THEN, ELSE format
 */
public class ConditionalStmt extends Stmt {
	private Expr expr;
	private Stmts thenStmts;
	private Stmts elseStmts;

    /**
     * Constructor method to create the contents of a conditional statement object
     * @param expr The If Expression
     * @param thenStmts What to do if true (Stmts)
     * @param elseStmts What to do if false (Stmts)
     */
	public ConditionalStmt(Expr expr, Stmts thenStmts, Stmts elseStmts) {
		this.expr = expr;
		this.thenStmts = thenStmts;
		this.elseStmts = elseStmts;
	}

	/*
	 * This parse method returns a stmt like others, but this time we have different
	 * private fields which are used in the codegen function
	 */

	/**
	 * Returns a Stmt object
	 * @return
	 * @throws ParsingException
	 */

	public static Stmt parse() throws ParsingException{
		Expr expr = null;
		Stmts thenStmts = null;
		Stmts elseStmts = null;
		
		if (ParsingHelper.expected(KeywordToken.class, "IF", true)) {
			Parser.t = Lexer.lex();
			expr = Expr.parse();
		} 
		
//		Parser.t = Lexer.lex();
		if (ParsingHelper.expected(KeywordToken.class, "THEN", true)) {
			Parser.t = Lexer.lex();
			thenStmts = Stmts.parse();
		} 
		
//		Parser.t = Lexer.lex();
		if (ParsingHelper.expected(KeywordToken.class, "ELSE", true)) {
			Parser.t = Lexer.lex();
			elseStmts = Stmts.parse();
		} 
		
//		Parser.t = Lexer.lex();
		if (ParsingHelper.expected(KeywordToken.class, "ENDIF", true)) {
			Parser.t = Lexer.lex();
			return new ConditionalStmt(expr, thenStmts, elseStmts);
		} 

		return null;
	}

    /**
     * This method is used to ensure correct parsing and then the actual output to destination file.
     */
	@Override
	public void codegen() {
		expr.codegen();
		Output.writeToFile("{");
		thenStmts.codegen();
		Output.writeToFile("} {");
		elseStmts.codegen();
		Output.writeToFile("} ifelse");
	}

}
