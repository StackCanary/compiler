package test;

import static org.junit.Assert.*;

import org.junit.Test;

import token.Tokenizer;
import token.Tokenizer.OperatorTokenAssist;
import token.Tokenizer.TokenAssist;

public class TokenTest {

	@Test
	public void testTokenAssist() {
		assertTrue(Tokenizer.matchesRegex(TokenAssist.digit.getRegex(), "1"));
		assertTrue(Tokenizer.matchesRegex(TokenAssist.number.getRegex(), "321"));
		assertTrue(Tokenizer.matchesRegex(TokenAssist.control_flow.getRegex(), "IF"));
		assertTrue(Tokenizer.matchesRegex(TokenAssist.ident.getRegex(), "ident123"));
	}
	
	@Test
	public void testOperatorTokenAssist() {
		assertTrue(Tokenizer.matchesRegex(OperatorTokenAssist.binary_operator.getRegex(), "+"));
		assertTrue(Tokenizer.matchesRegex(OperatorTokenAssist.comparison_operator.getRegex(), "<="));
		assertTrue(Tokenizer.matchesRegex(OperatorTokenAssist.paren.getRegex(), "{"));
		
	}

}
