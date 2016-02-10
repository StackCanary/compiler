package expr;
import  logoCompiler.lexer.*;
import logoCompiler.parser.Parser;
import token.IdentToken;
/*
 * primary-expr:
 *   num
 *   ident
 */
public abstract class PrimaryExpr extends Expr {
  public static Expr parse() {
    if (Parser.t instanceof NumToken) {
      return NumExpr.parse();
    } else if (Parser.t instanceof IdentToken) {
      return IdentExpr.parse();
    } else {
      //error?
    } 
  }
}
