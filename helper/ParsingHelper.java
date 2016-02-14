package helper;

import exceptions.ParsingException;
import logoCompiler.parser.Parser;
import token.Token;
import token.Token.Symbol_t;

public class ParsingHelper {
	/*
	 * http://stackoverflow.com/questions/2240646/ 
	 * Passing types as a parameter
	 */
	public static boolean expected(Class<?> expectedToken, Boolean throwError) throws ParsingException {
		if (Parser.t.getClass() == expectedToken) {
			return true;
		}
		
		if (throwError) {
			throw new ParsingException("Expected " + expectedToken.toString() + " instead of " + Parser.t.getAttr());
		}
		
		return false;
		
	}
	
	public static boolean expected(Class<?> expectedToken, String attr, Boolean throwError) {
		if (Parser.t.getClass() == expectedToken && Parser.t.getAttr().equals(attr)) {
			return true;
		} 
		
		
		if (throwError) {
			throw new ParsingException("Expected " + expectedToken.toString() + " instead of " + Parser.t.getAttr());
			
		}
		
		return false;
	}
	
	public static boolean expected(Class<?> expectedToken, Symbol_t symbol, Boolean throwError) {
		if (Parser.t.getClass() == expectedToken) {
			if (Parser.t.getSymbol().equals(symbol)) {
				return true;
			}
		} 
		
		if (throwError) {
			throw new ParsingException("Expected " + expectedToken.toString() + " : " + symbol.toString() + " instead of " + Parser.t.getAttr() + " : " + Parser.t.getSymbol().toString());
		}
		
		return false;
	}
	

}
