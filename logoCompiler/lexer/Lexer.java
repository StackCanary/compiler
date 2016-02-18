package logoCompiler.lexer;

import filereading.FileReader;
import logoCompiler.parser.Parser;
import token.EOIToken;
import token.Token;
import token.TokenGenerator;
import token.Tokenizer;

/**
 * This class reads through the input and converts the stream into suitable tokens
 * for processing.
 */
public final class Lexer {
	/* The scope of this variable means it is used in both 
	 * lex() and getChar(), this was a subtle oversight 
	 * because in the original template. 
	 * 
	 * I changed the getChar/getCharacter function so it uses a local variable instead of the ch variable
	 * with the global scope 
	 */

	static int ch = getChar();
	static int peek = getChar();
	static TokenGenerator tGenerator = new TokenGenerator();

    /**
     * This method is used to return the next token to be used.
     * This method deals with null tokens and pushes the tokens onto the stack
     * just in case backtracking was needed.
     * @return The Token once decided upon
     */
	public static Token lex() {
		Token token = getToken();
		if (token == null) {
			return lex();
		}
		//System.out.println("Returning " + token.getAttr());
		Parser.tokens.push(token);
		return token;
	}

    /**
     * This is method returns the next token to be used.
     * @return The generated Token object.
     */
	public static Token getToken() {
		TokenGenerator tGenerator = new TokenGenerator();
		String currentString = "";
		//Consume the white space
		while (ch == ' ' || ch == '\n' || ch == '\t' || ch == '\r') {
			getCharacter();
		}
		
		/*
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


    /**
     * this reads chars from stdin. You can read in files any way you want, using FileReader etc.
     * @return the int of the next char.
     */
	static int getChar() {
		return FileReader.getChar();
	}

    /**
     * Provided there is a next character to get this method will update the variables 'ch' and 'peek'
     */
	static void getCharacter() {
		if (peek == -1) {
			ch = -1;
			return;
		}
		
		ch = peek;
		peek = getChar();
		
	}
}
