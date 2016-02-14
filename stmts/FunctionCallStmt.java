package stmts;

import expr.Expr;
import expr.IdentExpr;
import helper.ParsingHelper;
import logoCompiler.lexer.Lexer;
import logoCompiler.parser.Parser;
import token.IdentToken;
import token.ParenthesisToken;
import token.Token.Symbol_t;

public class FunctionCallStmt extends Stmt {
	private String name;
	private Expr expr;

	/*
	 * ident '(' expr ')' 
	 */
	public FunctionCallStmt(String name, Expr expr) {
		this.name = name;
		this.expr = expr;
	}

	/*
	 * This function will return a FunctionCallStmt
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

	@Override
	public void codegen() {
		// TODO Auto-generated method stub
		System.out.println("Arg");
		expr.codegen();
		System.out.println(name);
		System.out.println("/Arg exch def");
	}


}
