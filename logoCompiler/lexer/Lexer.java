package logoCompiler.lexer;
import java.util.*;

import token.EOIToken;
import token.Token;
import token.TokenGenerator;
import token.Tokenizer;


public final class Lexer {
	/* The scope of this variable means it is used in both 
	 * lex() and getChar() 
	 */
  static int ch = ' ';
  static TokenGenerator tGenerator = new TokenGenerator();
  
  public static Token lex() {
	 TokenGenerator tGenerator = new TokenGenerator();
	String currentString = "";
    //skip the white space
    while (ch == ' ' || ch == '\n' || ch == '\t') {
    	ch = getChar();
    	
    	if (ch == -1) {
    		return new EOIToken();
    	}
    	
    	tGenerator.submitCharacterTest("" + (char) ch);
    	if (tGenerator.hasNext()) {
    		return tGenerator.getNextToken();
    	}
    	
    	
    	while (Tokenizer.matchesRegex("[A-z0-9]", "" + (char) ch)) {
    		currentString += (char) ch;
    		ch = getChar();
    	}
    	
    	tGenerator.submitTest(currentString);
		if (tGenerator.hasNext()) {
			return tGenerator.getNextToken();
		}
    	
    }
    
    
    return null;
    
    
    
  }

  
  //this reads chars from stdin. You can read in files any way you want, using FileReader etc.
  static int getChar() {
    try {
      ch = System.in.read();
    } catch (Exception e) {
      System.out.println(e); System.exit(1);
    }
    return ch;
  }
}
