package stmts;

import exceptions.ParsingException;
import expr.Expr;
import helper.ParsingHelper;
import logoCompiler.lexer.Lexer;
import logoCompiler.parser.Parser;
import token.KeywordToken;

/*
 * IF" expr "THEN" stmts "ELSE" stmts "ENDIF"
 */
public class ConditionalStmt extends Stmt {
	private Expr expr;
	private Stmts thenStmts;
	private Stmts elseStmts;
	
	public ConditionalStmt(Expr expr, Stmts thenStmts, Stmts elseStmts) {
		this.expr = expr;
		this.thenStmts = thenStmts;
		this.elseStmts = elseStmts;
	}

	/*
	 * This parse method returns a stmt like others, but this time we have different
	 * private fields which are used in the codegen function
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
	
	@Override
	public void codegen() {
		expr.codegen();
		System.out.println("{");
		thenStmts.codegen();
		System.out.println("} {");
		elseStmts.codegen();
		System.out.println("} ifelse");
	}

}
