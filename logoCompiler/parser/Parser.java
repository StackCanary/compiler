package logoCompiler.parser;
import java.util.Stack;

import token.Token;

/**
 * This is the main class that is used in parsing... obviously... It contains the stack of
 * tokens that the program uses in its conversion from Logo to PS.
 */
public final class Parser {
  public static Token t;
  public static Stack<Token> tokens = new Stack<Token>();
  public static boolean error = false;
  public static Token expectedToken;
}
