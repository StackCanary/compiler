package token;

/**
 * This class is used to hand out Tokens as they are created
 */
public class TokenGenerator {
	public Token tokenNext;

    /**
     * This method is used to work out if there are more tokens still to come.
     * @return boolean value based on - if there are more to come or not.
     */
	public boolean hasNext() {
		if (tokenNext != null) {
			return true;
		} else {
			return false;
		}
	}

    /**
     * This method gives out the next token as it is requested
     * @return Returns the actual token on request.
     */
	public Token getNextToken() {
		Token result = tokenNext;
		tokenNext = null;
		return result;
	}

    /**
     * This method is used to find out if there is a further token to come and sets the class-local variable to it if true
     * @param pToken Use this string to work out if further tokens are to come.
     */
	public void submitTest(String pToken) {
		tokenNext = Tokenizer.getTokenFromString(pToken);
	}

    /**
     * This method is used to work out if there are further tokens to be created in the form of operators
     * @param pToken The string to use to work out if this is true or false.
     */
	public void submitOperatorTest(String pToken) {
		tokenNext = Tokenizer.getOperatorTokenFromString(pToken);
	}
	
}
