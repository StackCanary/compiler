package expr;

import logoCompiler.Output;
import logoCompiler.parser.Parser;

public class NumExpr extends PrimaryExpr{
	private String name;
	
	/*
	 * Over here we will use a Stack to revert the token to where it was before
	 */
	
	public NumExpr(String name) {
		this.name = name;
	}
	
	public static Expr parse() {
		String name = Parser.t.getAttr();
		return new NumExpr(name);
	}
	
	@Override
	public void codegen() {
		Output.writeToFile(name);
	}
	
	
	
}
