package token;

public abstract class OperatorToken extends Token {
	public abstract String psOpCode();
	public abstract int precedence();
}
