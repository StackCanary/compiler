package token;

public class TokenGenerator {
	public Token tokenNext;
	
	public boolean hasNext() {
		if (tokenNext != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Token getNextToken() {
		Token result = tokenNext;
		tokenNext = null;
		return result;
	}
	
	public void submitTest(String pToken) {
		tokenNext = Tokenizer.getTokenFromString(pToken);
	}
	
	public void submitOperatorTest(String pToken) {
		tokenNext = Tokenizer.getOperatorTokenFromString(pToken);
	}
	
}
