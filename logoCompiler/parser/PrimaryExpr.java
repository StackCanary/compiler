package logoCompiler.parser;
import  logoCompiler.lexer.*;
import token.IdentToken;
/*
 * primary-expr:
 *   num
 *   ident
 */
public abstract class PrimaryExpr extends Expr {
  public static Expr parse() {
    if (OldParser.t instanceof NumToken) {
      return NumExpr.parse();
    } else if (OldParser.t instanceof IdentToken) {
      return IdentExpr.parse();
    } else {
      //error?
    } 
  }
}
