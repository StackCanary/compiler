package operatortokens;

import token.Token;

public abstract class OperatorToken extends Token {
	public abstract String psOpCode();
	public abstract int precedence();
	
	public OperatorToken(String attr) {
		super(attr);
	}
}