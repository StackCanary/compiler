package token;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used to convert from the Logo input into tokens to be analysed by the parser.
 */
public class Tokenizer {

	/*
	 * http://stackoverflow.com/questions/6667243/
	 */
	
    /**
     * This stores the regular expressions for pattern matching operators
     */
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

    /**
     * This stores the regular expressions for pattern matching regular Tokens
     */
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

    /**
     * This method is used to work out if the input string conforms to a regex specification
     * @param regex The regex specification to compare against
     * @param testString The string to compare
     * @return the true/false result if a match is found.
     */
	public static boolean matchesRegex(String regex, String testString) {
		if (regex == null) {
			return false;
		}
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(testString);

		return m.find();
	}

    /**
     * This method is used to extract a TokenAssist using the input string for the comparison
     * @param pToken The string to analyse
     * @return A TokenAssist
     */
	public static TokenAssist getToken(String pToken) {
		for (TokenAssist x : TokenAssist.values()) {
			if (matchesRegex(x.getRegex(),pToken)) {
				return x;
			} 
		}
		
		return TokenAssist.unidentified;
	}

    /**
     * This method is used to extract an operator position using the input string for the comparison
     * @param pToken The string to analyse
     * @return the position of operatorToken in its collection.
     */
	public static OperatorTokenAssist getOperatorToken(String pToken) {
		for (OperatorTokenAssist x : OperatorTokenAssist.values()) {
			if (matchesRegex(x.getRegex(),pToken)) {
				return x;
			} 
		}
		
		return OperatorTokenAssist.unidentified;
	}

    /**
     * This method is used to create the token based on the input
     * @param token This is used to decide which kind of token is being matched
     * @param pToken This is the string to compare against
     * @return This is the newly created token of desired kind.
     */
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

    /**
     * This Method is used to convert the input string into the correct kind of token
     * @param pToken The string to convert
     * @return The output token
     */
	public static Token getTokenFromString(String pToken) {
		TokenAssist token = getToken(pToken);
		return createToken(token, pToken);
	}

    /**
     * This method is used to work out which kind of operator token should be created from the input Token
     * @param OperatorAssistToken Enum to help decide the type being analysed
     * @param pToken The string to pass to the Token being created
     * @return The newly created Token
     */
	public static Token createOperatorToken(OperatorTokenAssist token, String pToken) {
		switch (token) {
		
		case binary_operator:
			return new BinaryToken(pToken);
		case asignment_operator:
			return new AssignmentToken(pToken);
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

    /**
     * This method takes in the string and converts it into an operator type token
     * @param pToken The string to convert
     * @return The newly created Token object
     */
	public static Token getOperatorTokenFromString(String pToken) {
		OperatorTokenAssist token = getOperatorToken(pToken);
		return createOperatorToken(token, pToken);
	}
}
