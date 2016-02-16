package stmts;

import expr.Expr;
import logoCompiler.Output;
import logoCompiler.lexer.Lexer;
import logoCompiler.parser.Parser;

public class ForwardStmt extends Stmt {
	private Expr expr;

	public ForwardStmt(Expr expr) {
		this.expr = expr;
	}

	public static Stmt parse() {
		// Extra .lex() helps here
		Parser.t = Lexer.lex();
		Expr expr = Expr.parse();
		return new ForwardStmt(expr);
	}

	@Override
	public void codegen() {
		expr.codegen();
		Output.writeToFile("Forward");
	}
}
