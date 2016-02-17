package token;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

	public static enum OperatorTokenAssist {
		binary_operator ("^(\\+|\\-|\\*|\\/)$"),
		asignment_operator("^=$"),
		comparison_operator ("^(==|!=|<|>|<=|>=|!)$"),
		paren ("^(\\(|\\)|\\{|\\})$"),
		unidentified;
		
		private String regex;

		OperatorTokenAssist() {

		}

		OperatorTokenAssist(String s) {
			regex = s;
		}
		
		
		public String getRegex() {
			return regex;
		}
	}
	
	public static enum TokenAssist {
		digit ("^[0-9]$"),	/* Literals */
		number ("^[0-9]+$"),
		control_flow ("^IF|THEN|ELSE|ENDIF$"),
		proc ("^PROC$"),
		void_ ("^VOID$"),
		ident("^[A-z]+([A-z]?|[A-z0-9]+)$"),
		unidentified;
		
		private String regex;
		
		TokenAssist() {

		}
		
		TokenAssist(String s) {
			regex = s;
		}


		public String getRegex() {
			return regex;
		}


	}

	
	public static boolean matchesRegex(String regex, String testString) {
		if (regex == null) {
			return false;
		}
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(testString);
		
		
		
		return m.find();
	}

	public static TokenAssist getToken(String pToken) {
		for (TokenAssist x : TokenAssist.values()) {
			if (matchesRegex(x.getRegex(),pToken)) {
				return x;
			} 
		}
		
		return TokenAssist.unidentified;
	}
	
	public static OperatorTokenAssist getOperatorToken(String pToken) {
		for (OperatorTokenAssist x : OperatorTokenAssist.values()) {
			if (matchesRegex(x.getRegex(),pToken)) {
				return x;
			} 
		}
		
		return OperatorTokenAssist.unidentified;
	}
	
	public static Token createToken(TokenAssist token, String pToken) {
		switch (token) {
		case number:
			return new NumberToken(pToken);
		case digit:
			return new NumberToken(pToken);
		case control_flow:
			return new KeywordToken(pToken);
		case void_:
			return new IdentToken(pToken);
		case proc:
			return new PROCToken(pToken);
		case ident:
			return new IdentToken(pToken);
		case unidentified:
			return null;
		default:
			return null;
		}
		
	}
	
	public static Token getTokenFromString(String pToken) {
		TokenAssist token = getToken(pToken);
		return createToken(token, pToken);
	}
	
	public static Token createOperatorToken(OperatorTokenAssist token, String pToken) {
		switch (token) {
		
		case binary_operator:
			return new BinaryToken(pToken);
		case asignment_operator:
			return new AsignmentToken(pToken);
		case comparison_operator:
			return new ComparisonToken(pToken);
		case paren:
			return new ParenthesisToken(pToken);
		case unidentified:
			return null;
		default:
			return null;
		}
	}
	
	public static Token getOperatorTokenFromString(String pToken) {
		OperatorTokenAssist token = getOperatorToken(pToken);
		return createOperatorToken(token, pToken);
	}
	
	
}
