package token;

import operatortokens.OperatorToken;

public class ComparisonToken extends OperatorToken{
	public ComparisonToken(String attr) {
		super(attr);
	}

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

	@Override
	public int precedence() {
		return 1;
	}


}
