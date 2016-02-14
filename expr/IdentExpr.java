package expr;

import logoCompiler.parser.Parser;

public class IdentExpr extends PrimaryExpr {
	private String name;
	/*
	 * Over here we will use a Stack to revert the token to where it was before
	 */
	
	
	public IdentExpr(String name) {
		this.name = name;
	}
	
	public static Expr parse() {
		String name = Parser.t.getAttr();
		return new IdentExpr(name);
	}
	
	@Override
	public void codegen() {
		System.out.println("Arg");
	}
	
	
}
