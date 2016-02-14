package logoCompiler.lexer;
import java.util.*;

import filereading.FileReader;
import logoCompiler.parser.Parser;
import token.ComparisonToken;
import token.EOIToken;
import token.Token;
import token.TokenGenerator;
import token.Tokenizer;


public final class Lexer {
	/* The scope of this variable means it is used in both 
	 * lex() and getChar(), this was a subtle oversight 
	 * because in the original template. 
	 */

	static int ch = getChar();
	static int peek = getChar();
	static TokenGenerator tGenerator = new TokenGenerator();
	
	public static Token lex() {
		Token token = getToken();
		if (token == null) {
			return lex();
		}
		System.out.println("Returned : " + token.getAttr());
		Parser.tokens.push(token);
		return token;
	}
	
	public static Token getToken() {
		TokenGenerator tGenerator = new TokenGenerator();
		String currentString = "";
		//Consume the white space
		while (ch == ' ' || ch == '\n' || ch == '\t' || ch == '\r') {
			getCharacter();
		}
		
		/**
		 * Return end of input Token
		 */
		if (ch == -1) {
			return new EOIToken("" + (char) ch);
		}
		
		tGenerator.submitOperatorTest("" + (char) ch); 
		if (tGenerator.hasNext()) {
			Token currentToken = tGenerator.getNextToken();
			if (peek == '=') {
				tGenerator.submitOperatorTest("" + (char) ch + (char) peek); 
				if (tGenerator.hasNext()) {
					getCharacter();
					getCharacter();
					return tGenerator.getNextToken();
				}
			}
			getCharacter();
			return currentToken;
		}


		while (Tokenizer.matchesRegex("[A-z0-9]", "" + (char) ch)) {
			currentString += (char) ch;
			getCharacter();
		}
		
	
		tGenerator.submitTest(currentString);
		if (tGenerator.hasNext()) {
			return tGenerator.getNextToken();
		}
		
		getCharacter();

		return null;

	}
	


	//this reads chars from stdin. You can read in files any way you want, using FileReader etc.
	static int getChar() {
		return FileReader.getChar();
	}

	static void getCharacter() {
		if (peek == -1) {
			ch = -1;
			return;
		}
		
		ch = peek;
		peek = getChar();
		
	}
}
