package expr;
import helper.ParsingHelper;
import token.IdentToken;
import token.NumberToken;
/*
 * primary-expr:
 *   num
 *   ident
 */

/**
 * This abstract class defines the basis and method of parsing a Primary type Expression
 */
public abstract class PrimaryExpr extends Expr {

    /**
     * This method is used to self parse the Expression
     * @return The parsed Expression.
     */
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
