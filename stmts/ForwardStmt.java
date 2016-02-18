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
     * This Constructor is used to create the forward statement using the input expression
     * @param expr The expression used to form the Stmt.
     */
	public ForwardStmt(Expr expr) {
		this.expr = expr;
	}

    /**
     * Parses a Forward Stmt
     * @return The properly parsed statement.
     */
	public static Stmt parse() {
		// Extra .lex() helps here
		Parser.t = Lexer.lex();
		Expr expr = Expr.parse();
		return new ForwardStmt(expr);
	}

    /**
     * Generates the call for a Forward function call
     */
	@Override
	public void codegen() {
		expr.codegen();
		Output.writeToFile("Forward");
	}
}
