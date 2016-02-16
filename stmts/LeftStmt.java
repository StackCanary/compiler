
package stmts;
import expr.Expr;
import logoCompiler.Output;
import  logoCompiler.lexer.*;
import logoCompiler.parser.Parser;

/*
 *   "LEFT" expr
 */
public final class LeftStmt extends Stmt {
	private Expr expr;

	public LeftStmt(Expr expr) {
		this.expr = expr;
	}

	public static Stmt parse() {

		Parser.t = Lexer.lex();
		Expr expr = Expr.parse();
		return new LeftStmt(expr);
	}

	@Override
	public void codegen() {
		expr.codegen();
		Output.writeToFile("Left");
	}
}
