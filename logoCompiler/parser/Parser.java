package logoCompiler.parser;
import java.util.Stack;

import  logoCompiler.lexer.*;
import token.Token;

public final class Parser {
  public static Token t;
  public static Stack<Token> tokens = new Stack<Token>();
  public static boolean error = false;
  public static Token expectedToken;
}
