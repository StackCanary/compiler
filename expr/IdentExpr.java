package expr;

import logoCompiler.Output;
import logoCompiler.parser.Parser;

/**
 * This class is used to represent an 'Ident' expression
 */
public class IdentExpr extends PrimaryExpr {

	private String name;
	/*
	 * Over here we will use a Stack to revert the token to where it was before
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
     * This method is used to push an 'Arg' to the stack as part of the order of code generation for PS.
     */
	@Override
	public void codegen() {
		Output.writeToFile("Arg");
	}
	
	
}
