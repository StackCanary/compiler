package stmts;

import expr.Expr;
import logoCompiler.Output;
import logoCompiler.lexer.Lexer;
import logoCompiler.parser.Parser;

/**
 * This class represents the Forward Statement type.
 */
public class ForwardStmt extends Stmt {
	private Expr expr;

    /**
     * This Constructor is used to create the forward statement using the inputted expression
     * @param expr The expression used to form the stmt.
     */
	public ForwardStmt(Expr expr) {
		this.expr = expr;
	}

    /**
     * Method to allow the class to be able to parse itself and give proper output.
     * @return The properly parsed statement.
     */
	public static Stmt parse() {
		// Extra .lex() helps here
		Parser.t = Lexer.lex();
		Expr expr = Expr.parse();
		return new ForwardStmt(expr);
	}

    /**
     * Method to provide output to the destination file.
     */
	@Override
	public void codegen() {
		expr.codegen();
		Output.writeToFile("Forward");
	}
}
