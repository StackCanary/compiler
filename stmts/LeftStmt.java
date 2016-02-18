
package stmts;
import expr.Expr;
import logoCompiler.Output;
import  logoCompiler.lexer.*;
import logoCompiler.parser.Parser;

/*
 *   "LEFT" expr
 */

/**
 * This class represents the Forward Statement type.
 */
public final class LeftStmt extends Stmt {
	private Expr expr;

    /**
     * This Constructor is used to create the Left statement using the inputted expression
     * @param expr The expression used to form the stmt.
     */
	public LeftStmt(Expr expr) {
		this.expr = expr;
	}

    /**
     * Method to allow the class to be able to parse itself and give proper output.
     * @return The properly parsed statement.
     */
	public static Stmt parse() {
		Parser.t = Lexer.lex();
		Expr expr = Expr.parse();
		return new LeftStmt(expr);
	}

    /**
     * Generates the call to the Left function call
     */
	@Override
	public void codegen() {
		expr.codegen();
		Output.writeToFile("Left");
	}
}
