package expr;

import logoCompiler.Output;
import logoCompiler.parser.Parser;

/**
 * This class is used to represent an 'Ident' expression
 */
public class IdentExpr extends PrimaryExpr {

	private String name;
	/*
	 * I intended use a Stack to revert the token to where it was before, but
	 * FraserHansen doesn't require backtracking
	 */

    /**
     * Constructor to create an IdentExpr object
     * @param name The input string that defines the expressions function
     */
	public IdentExpr(String name) {
		this.name = name;
	}

    /**
     * This method is used to parse the object that contains it and return the corrected Expr
     * @return The corrected Expr.
     */
	public static Expr parse() {
		String name = Parser.t.getAttr();
		return new IdentExpr(name);
	}

    /**
     * This code generated here is used to push the contents of the 'Arg' register onto to the stack.
     */
	@Override
	public void codegen() {
		Output.writeToFile("Arg");
	}
	
	
}
