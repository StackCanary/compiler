package test;

import java.util.ArrayList;

import logoCompiler.lexer.Lexer;
import token.EOIToken;
import token.Token;

public class TokenDebugging {
	
	public static void main(String args[]) {
		ArrayList<Token> tokenList = new ArrayList<Token>();
		Token token = null;
		while (!(token instanceof EOIToken)) {
			token = Lexer.lex();
			tokenList.add(token);
		}
		
		
	} 

}
