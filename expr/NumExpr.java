package expr;

import logoCompiler.Output;
import logoCompiler.parser.Parser;

/**
 * This class is used to represent a number expression
 */
public class NumExpr extends PrimaryExpr{
	private String name;
	
	/*
	 * Over here we will use a Stack to revert the token to where it was before
	 */

    /**
     * Constructor to create a NumExpr object
     * @param name The input string used to create the objects function.
     */
	public NumExpr(String name) {
		this.name = name;
	}

    /**
     * This method is used to parse the object that contains it and return the corrected Expr
     * @return The corrected Expr.
     */
	public static Expr parse() {
		String name = Parser.t.getAttr();
		return new NumExpr(name);
	}

    /**
     * This method is used to write the primary expressions function to the output destination
     */
	@Override
	public void codegen() {
		Output.writeToFile(name);
	}
}
