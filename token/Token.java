package token;


public abstract class Token {
	private String attr;

	public static enum Symbol_t {
		LParen,
		RParen,
		LBrace,
		RBrace,
		LessThan,
		GreaterThan,
		EqualEquals,
		LessOrEquals,
		GreaterOrEquals,
		NotEquals,
		Plus,
		Minus,
		Multiply,
		Divide;
	}
	
	private Symbol_t symbol;
	
	public Token() {
		
	}
	
	public Token(String attr) {
		this.attr = attr;
		setParen(attr);
	}
	
	public int precedence() {
		//set precedence of all non-operators to 0
		//Override this for Operators
	    return 0;
	  } 
	
	/*
	 * Override this method for all tokens with attributes
	 */
	public String getAttr() {
		return null;
	}
	
	
	private void setParen(String attr) {
		switch (attr) {
		case "(":
			symbol = Symbol_t.LParen;
			break;
		case ")":
			symbol = Symbol_t.RParen;
			break;
		case "{":
			symbol = Symbol_t.LBrace;
			break;
		case "}":
			symbol = Symbol_t.RBrace;
			break;
		case "<":
			symbol = Symbol_t.LessThan;
			break;
		case ">":
			symbol = Symbol_t.GreaterThan;
			break;
		case "<=":
			symbol = Symbol_t.LessOrEquals;
			break;
		case ">=":
			symbol = Symbol_t.GreaterOrEquals;
			break;
		case "!=":
			symbol = Symbol_t.NotEquals;
			break;
		case "+":
			symbol = Symbol_t.Plus;
			break;
		case "-":
			symbol = Symbol_t.Minus;
			break;
		case "*":
			symbol = Symbol_t.Multiply;
			break;
		case "/":
			symbol = Symbol_t.Divide;
			break;
		
		

		/* No default case, perhaps I should have one */
		}
	}
	
}
