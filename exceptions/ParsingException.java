package exceptions;

public class ParsingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParsingException(String message) {
		super("Parsing Error, Incorrect Token. " + message);
	}
	
}