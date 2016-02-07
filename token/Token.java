package token;
public abstract class Token {
	private String attr;
	
	public Token() {
		
	}
	
	public Token(String attr) {
		this.attr = attr;
	}
	
	public int precedence() {
		//set precedence of all non-operators to 0
		//Override this for Operators
	    return 0;
	  } 
	
	/*
	 * Override this method for all tokens with attributes
	 */
	public String getAttr() {
		return null;
	}
	
}
