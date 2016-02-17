package token;

import operatortokens.OperatorToken;

public class BinaryToken extends OperatorToken{
	public BinaryToken(String attr) {
		super(attr);
	}

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
