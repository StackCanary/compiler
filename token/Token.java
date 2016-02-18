package token;

/**
 * This Class is used to represent the overall Token object type
 */
public abstract class Token {
	private String attr;

    /**
     * Enumeration of all of the possible token symbols for use within compiler operation
     */
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
		Divide
	}
	private Symbol_t symbol;

    /**
     * Method to set the current attr value to the input kind
     * @param attr The attr value to set to the current value
     */
	public Token(String attr) {
		this.attr = attr;
		setParen(attr);
	}

    /**
     * set precedence of all non-operators to 0
     * Override this for Operators
     * @return the precedence value.
     */
	public int precedence() {
	    return 0;
	  }

    /**
     * Simple method to return the current attribute value of the object
     * @return the string of the current attribute
     */
	public String getAttr() {
		return this.attr;
	}

    /**
     * Simple setter method to set the current Attribute value of the object
     * @param attr the incoming attribute to be changed and assigned to this objects attr
     */
	public void setAttr(String attr) {
		this.attr = attr;
	}

    /**
     * Simple getter method to return the symbol to caller
     * @return The current symbol allocation
     */
	public Symbol_t getSymbol() {
		return symbol;
	}

    /**
     * Method to decide which kind of parenthesis/other symbol is being used and return a
     * corrosponding token type in the symbol variable.
     * @param attr the incoming data for comparison and conversion.
     */
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
