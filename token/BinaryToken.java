package token;

import operatortokens.OperatorToken;

/**
 * This method is used to represent a binary type token.
 */
public class BinaryToken extends OperatorToken{
	public BinaryToken(String attr) {
		super(attr);
	}

    /**
     * This method is used to decide which kind of operation is trying to be carried out
     * and returns the PS equivalent
     * @return The PS equivalent of the input operation type.
     */
	@Override
	public String psOpCode() {
		switch (getAttr()) {
		case "*":
			return "mul";
		case "/":
			return "div";
		case "+":
			return "add";
		case "-":
			return "sub";
		}
	
		return null;
	}

    /**
     * Sets which precedence value the different kind of operations have (BIDMAS Style)
     * @return the integer representing precedence.
     */
	@Override
	public int precedence() {
		switch (getAttr()) {
		case "*":
		case "/":
			return 3;
		case "-":
		case "+":
			return 2;
		}
		return 0;
	}
}
