package stmts;

import expr.Expr;
import logoCompiler.lexer.Lexer;
import logoCompiler.parser.Parser;

public class RightStmt extends Stmt{
	private Expr expr;
		
	public RightStmt(Expr expr) {
		this.expr = expr;
	}

	public static Stmt parse() {

		Parser.t = Lexer.lex();
		Expr expr = Expr.parse();
		return new RightStmt(expr);
	}

	@Override
	public void codegen() {
		expr.codegen();
		System.out.println("Right");
	}
}
