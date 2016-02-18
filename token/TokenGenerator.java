package token;

/**
 * This class is used to generate a Token
 */
public class TokenGenerator {
	public Token tokenNext;

    /**
     * This method is used determines if a Token has been generated
     * @return boolean 
     */
	public boolean hasNext() {
		if (tokenNext != null) {
			return true;
		} else {
			return false;
		}
	}

    /**
     * This method gives out the next token as it is requests
     * @return Returns the actual token on request.
     */
	public Token getNextToken() {
		Token result = tokenNext;
		tokenNext = null;
		return result;
	}

    /**
     * This method submits a test on a potential Token on which a Token is created if it exists
     * @param pToken Use this string to work out if further tokens are to come.
     */
	public void submitTest(String pToken) {
		tokenNext = Tokenizer.getTokenFromString(pToken);
	}

    /**
     * This method submits a test on a potential character Token on which a Token is created if it exists
     * @param pToken The string to use to work out if this is true or false.
     */
	public void submitOperatorTest(String pToken) {
		tokenNext = Tokenizer.getOperatorTokenFromString(pToken);
	}
	
}
