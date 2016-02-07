package logoCompiler.lexer;
import java.util.*;

import token.EOIToken;
import token.Token;
import token.TokenGenerator;


public final class Lexer {
	/* Subtle oversight, but the scope of this variable means it is used in both 
	 * lex and getChar() */
  static int ch = ' ';
  static TokenGenerator tGenerator = new TokenGenerator();
  
  public static Token lex() {
	String currentString = "";
    //skip the white space
    while (ch == ' ' || ch == '\n' || ch == '\t') {
    	ch = getChar();
    }
	
		/* Return a token for EOF */	
		if (ch == -1) {
			return new EOIToken();
		}

    currentString += (char) ch;
    //identify new character and return correct token
    System.out.println(currentString);
    tGenerator.submitTest(currentString);
    if (tGenerator.hasNext()) {
    	currentString = "";
    	return tGenerator.getNextToken();
    }
   
    
    /* This probably shouldn't return null */
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
