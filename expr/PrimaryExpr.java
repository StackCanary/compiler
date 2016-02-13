package expr;
import helper.ParsingHelper;
import  logoCompiler.lexer.*;
import logoCompiler.parser.Parser;
import token.IdentToken;
import token.NumberToken;
/*
 * primary-expr:
 *   num
 *   ident
 */
public abstract class PrimaryExpr extends Expr {
  public static Expr parse() {
    if (ParsingHelper.expected(NumberToken.class, false)) {
      return NumExpr.parse();
    } else if (ParsingHelper.expected(IdentToken.class, true)) {
      return IdentExpr.parse();
    } else {
      //error?
    } 
    
    return null;
  }
}
