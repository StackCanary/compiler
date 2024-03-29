package helper;

import exceptions.ParsingException;
import logoCompiler.parser.Parser;
import token.Token.Symbol_t;

/**
 * This method is used to help decide if the order of tokens received was in a syntactically correct order or not.
 */
public class ParsingHelper {
	/*
	 * http://stackoverflow.com/questions/2240646/ 
	 * Passing types as a parameter
	 */

	/**
	 * This method is used to work out if the following token was expected or not
	 * @param expectedToken The token that is desired to be next
	 * @param throwError decide whether a Parsing Exception should be thrown manually or not.
	 * @return Boolean result of the order correctness
	 * @throws ParsingException
	 */
	public static boolean expected(Class<?> expectedToken, Boolean throwError) throws ParsingException {
		try {
			if (Parser.t.getClass() == expectedToken) {
				return true;
			}


			if (throwError) {
				System.out.println("Expected " + expectedToken.toString() + " instead of " + Parser.t.getAttr());
				Parser.error = true;
				System.exit(1);
			}
		} catch(NullPointerException e) {
			System.out.println("Unexpected Symbol");
			return false;
		}

		return false;

	}

	/**
	 * This method is used to work out if the following token was expected or not
	 * @param expectedToken The token that is desired to be next
	 * @param attr The attribute that is desired to be next
	 * @param throwError decide whether a Parsing Exception should be thrown manually or not.
	 * @return Boolean result of the order correctness
	 */
	public static boolean expected(Class<?> expectedToken, String attr, Boolean throwError) throws ParsingException{
		try {

			if (Parser.t.getClass() == expectedToken && Parser.t.getAttr().equals(attr)) {
				return true;
			} 

			if (throwError) {
				System.out.println("Expected " + expectedToken.toString() + " instead of " + Parser.t.getAttr());
				Parser.error = true;
				System.exit(1);
			}

		} catch(NullPointerException e) {
			System.out.println("Unexpected Symbol");
			return false;
		}

		return false;
	}

	/**
	 * This method is used to work out if the following token was expected or not
	 * @param expectedToken The token that is desired to be next
	 * @param symbol The symbol that is desired to be next
	 * @param throwError decide whether a Parsing Exception should be thrown manually or not.
	 * @return Boolean result of the order correctness
	 */
	public static boolean expected(Class<?> expectedToken, Symbol_t symbol, Boolean throwError) throws ParsingException{
		try {

			if (Parser.t.getClass() == expectedToken) {
				if (Parser.t.getSymbol().equals(symbol)) {
					return true;
				}
			} 


			if (throwError) {
				System.out.println("Expected " + expectedToken.toString() + " : " + symbol.toString() + " instead of " + Parser.t.getAttr() + " : " + Parser.t.getSymbol().toString());
				Parser.error = true;
				System.exit(1);
			}

		} catch(NullPointerException e) {
			System.out.println("Unexpected Symbol");
			return false;
		}

		return false;
	}
}