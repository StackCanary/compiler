package expr;

import logoCompiler.Output;
import logoCompiler.parser.Parser;

/**
 * This class is used to represent a number expression
 */
public class NumExpr extends PrimaryExpr{
	private String name;
	
    /**
     * Constructor to create a NumExpr object
     * @param name The input string used to create the objects function.
     */
	public NumExpr(String name) {
		this.name = name;
	}

    /**
     * This method parses number expressions and returns an Expr object
     * @return The corrected Expr.
     */
	public static Expr parse() {
		String name = Parser.t.getAttr();
		return new NumExpr(name);
	}

    /**
     * The number is simply pushed onto the stack
     */
	@Override
	public void codegen() {
		Output.writeToFile(name);
	}
}
