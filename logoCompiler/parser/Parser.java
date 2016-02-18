package logoCompiler.parser;
import java.util.Stack;

import token.Token;

/**
 * This class stores the global static variable that hold the current Token 
 * and the state of the parser.
 */
public final class Parser {
  public static Token t;
  public static Stack<Token> tokens = new Stack<Token>();
  public static boolean error = false;
  public static Token expectedToken;
}
