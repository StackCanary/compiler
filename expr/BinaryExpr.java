package expr;
import logoCompiler.Output;
import operatortokens.OperatorToken;

/*
 * binary-expr:
 *   expr op expr
 *
 *   where op is one of '+',  '-',  '*', '/',
 *                      '==', '!=', '>', '<', '<=', '>='
 */

/**
 * This class represents a binary expression in Logo
 */
public final class BinaryExpr extends Expr {
    public Expr  left;
    public OperatorToken oper;
    public Expr  right;

    /**
     * This Constructor is used to fill the attributes of the Binary Expression as called by
     *  precedence setting method "fraserHanson".
     * @param left This is the expression on the left side of the operator.
     * @param oper This is the kind of operation that is going to be carried out on the two expressions.
     * @param right This is the expression on the right hand side of the operator.
     */
    public BinaryExpr(Expr left, OperatorToken oper, Expr right) {
    this.left  = left;
    this.oper  = oper;
    this.right = right;
    }

    /**
     *This method is where the Logo code coverts itself and prints into PS directly
     */
    @Override
    public void codegen() {
        left.codegen();
        right.codegen();
        Output.writeToFile(oper.psOpCode());
    }
}
