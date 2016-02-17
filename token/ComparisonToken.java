package token;

import operatortokens.OperatorToken;

/**
 * This class is used to represent a binary comparison type token
 */
public class ComparisonToken extends OperatorToken{
	public ComparisonToken(String attr) {
		super(attr);
	}

    /**
     * Work out which kind of operation is trying to be carried out
     * @return The String equivalent of the operation symbol
     */
	@Override
	public String psOpCode() {
		switch (this.getAttr()) {
		case "==":
			return "eq";
		case "!=":
			return "ne";
		case ">=":
			return "ge";
		case "<=":
			return "le";
		case ">":
			return "gt";
		case "<":
			return "lt";
		}
		return null;
	}

    /**
     * Sets the precedence value for this kind of operation.
     * @return the int value of precedence
     */
	@Override
	public int precedence() {
		return 1;
	}
}
