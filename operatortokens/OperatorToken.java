package operatortokens;

import token.Token;

/**
 * This class is used to describe the overall functions of the operator in an expression.
 * Also holds information used in the precedence of the operation.
 */
public abstract class OperatorToken extends Token {
	public abstract String psOpCode();
	public abstract int precedence();
	
	public OperatorToken(String attr) {
		super(attr);
	}
}