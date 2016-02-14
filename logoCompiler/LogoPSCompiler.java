package logoCompiler;

import filereading.FileReader;
import logoCompiler.lexer.*;
import logoCompiler.parser.*;
import sun.security.pkcs.ParsingException;

public class LogoPSCompiler {
	public static void main(String[] args) throws ParsingException {

		/*Get file descriptors*/
		FileReader.read();

		/*Set Parser.t to our initial Token*/
		Parser.t = Lexer.lex();

		/*This function will continue to retrieve tokens */
		Prog prog = Prog.parse();

		if (!Parser.error) {
			psPrologue();
			prog.codegen();
			psEpilogue();
		}
	}

	public static void psPrologue() {
		System.out.println("%!PS-Adobe-3.0");	// Adobe header
		/* rest of prologue ... */
		System.out.println("/Xpos    { 300 } def");
		System.out.println("/Ypos    { 500 } def");
		System.out.println("/Heading { 0   } def");
		System.out.println("/Arg     { 0   } def");
		//Implementation of Right, Left and Forward procedures in PostScript
		System.out.println("/Right   {");
		System.out.println("Heading exch add Trueheading");
		System.out.println("/Heading exch def");
		System.out.println("} def");
		System.out.println("/Left {");
		System.out.println("Heading exch sub Trueheading");
		System.out.println("/Heading exch def");
		System.out.println("} def");
		System.out.println("/Trueheading {");
		System.out.println("360 mod dup");
		System.out.println("0 lt { 360 add } if");
		System.out.println("} def");
		System.out.println("/Forward {");
		System.out.println("dup  Heading sin mul");
		System.out.println("exch Heading cos mul");
		System.out.println("2 copy Newposition");
		System.out.println("rlineto");
		System.out.println("} def");
		System.out.println("/Newposition {");
		System.out.println("Heading 180 gt Heading 360 lt");
		System.out.println("and { neg } if exch");
		System.out.println("Heading  90 gt Heading 270 lt");
		System.out.println("and { neg } if exch");
		System.out.println("Ypos add /Ypos exch def");
		System.out.println("Xpos add /Xpos exch def");
		System.out.println("} def");

		// This line is here for debugging purposes
		System.out.println("[ OUR CODE SHOULD APPEAR BELOW HERE]");
	}

	public static void psEpilogue() {
		// This line is here for debugging purposes
		System.out.println("[OUR CODE SHOULD APPEAR ABOVE HERE]");  


		/* epilogue ... */
		System.out.println("Xpos Ypos moveto");
		//Call Main to start
		System.out.println("MAIN");
		System.out.println("stroke");
		System.out.println("showpage");
	}
}
