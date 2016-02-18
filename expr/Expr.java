package expr;

import logoCompiler.lexer.*;
import logoCompiler.parser.Parser;
import operatortokens.OperatorToken;

/*
 * expr:
 *   primary-expr 
 *   binary-expr 
 */
/*
 * The caller calls lexer.lex()
 */

/**
 * This class is used as the basis for all "Expressions" within the compiler.
 */
public abstract class Expr {

		/*We need to differentiate between binary operations and primary expressions
		 * this is automagically done the in fraserHanson function 
		 */
	
		/* 
		 * primary-expr
		 * binary-expr ; 
		 */

    /**
     * This Constructor is used to return the expression to caller after working out precedence.
     * @return The Expression itself
     */
    public static Expr parse() {
        return fraserHanson(1);
    }

    /**
     * This method Parses expressions that involve precedence
     * @param k The input that helps to decide what the precedence value should match against.
     * @return The Expression output
     */
    //Binary Expressions precedence handler from Fraser and Hanson C Compiler book
    private static Expr fraserHanson(int k) {
        int   i;
        Expr  left;
        OperatorToken oper;
        Expr  right;
        left = PrimaryExpr.parse();

        Parser.t = Lexer.lex();

        for (i = Parser.t.precedence(); i >= k; i--) {
            while (Parser.t.precedence() == i) {
                oper = (OperatorToken) Parser.t;
                Parser.t = Lexer.lex();
                right = fraserHanson(i+1);
                left  = new BinaryExpr(left, oper, right);
            }
        }
        return left;
    }

    /**
     * Each expression implements its own codegen()
     */
    public abstract void codegen();
}
