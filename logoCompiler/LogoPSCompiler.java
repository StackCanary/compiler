package logoCompiler;

import exceptions.FileTypeException;
import exceptions.ParsingException;
import filereading.FileReader;
import logoCompiler.lexer.*;
import logoCompiler.parser.*;

/**
 * This is the main class which the compiler runs from.
 * Containing all of the main loop of the program
 */
public class LogoPSCompiler {

    /**
     * This is the main method for the whole program
     * @param args It is expected to have 2 arguments upon program execution
     *             The first is the input file to be read from (in .t format)
     *             The second is the name of the file to output to (with .ps extension)
     * @throws ParsingException
     * @throws FileTypeException
     */
	public static void main(String[] args) throws ParsingException, FileTypeException {

		//work out if the program is safe to initialise.
		try {
			if (args.length != 2) {
				Output.writeToConsole("Invalid Argument length: Please follow \"java logoCompiler/" +
						"LogoPSCompiler <LogoFile.t> <outputDestination.ps>\"");
			} else if ((!args[0].regionMatches(args[0].length() - 2, ".t", 0, 2)) |
					(!args[1].regionMatches(args[1].length() - 3, ".ps", 0, 3))) {

				if (!args[0].regionMatches(args[0].length() - 2, ".t", 0, 2)) {
					throw new FileTypeException("Expected \".t\" type file for input.");
				}
				if (!args[1].regionMatches(args[1].length() - 3, ".ps", 0, 3)) {
					throw new FileTypeException("Expected \".ps\" type file for output.");
				}
			} else {

			/*Get file descriptors*/
				FileReader.read(args[0]);

			/*set output destination*/
				Output.setOutput(args[1]);

			/*Set Parser.t to our initial Token*/
				Parser.t = Lexer.lex();

			/*This function will continue to retrieve tokens */
				Prog prog = Prog.parse();

				if (!Parser.error) {
					psPrologue();
					prog.codegen();
					psEpilogue();
				} else {
					System.out.println("There was an error in the compilation. Code generation was halted");
				}
			}
		}
		catch(FileTypeException e){
			Output.writeToConsole(e.getMessage());
		}

	}

    /**
     * This method prints out the preset PS code given as skeleton code.
     */
	public static void psPrologue() {
		Output.writeToFile("%!PS-Adobe-3.0");	// Adobe header
		/* rest of prologue ... */
		Output.writeToFile("/Xpos    { 300 } def");
		Output.writeToFile("/Ypos    { 500 } def");
		Output.writeToFile("/Heading { 0   } def");
		Output.writeToFile("/Arg     { 0   } def");
		//Implementation of Right, Left and Forward procedures in PostScript
		Output.writeToFile("/Right   {");
		Output.writeToFile("Heading exch add Trueheading");
		Output.writeToFile("/Heading exch def");
		Output.writeToFile("} def");
		Output.writeToFile("/Left {");
		Output.writeToFile("Heading exch sub Trueheading");
		Output.writeToFile("/Heading exch def");
		Output.writeToFile("} def");
		Output.writeToFile("/Trueheading {");
		Output.writeToFile("360 mod dup");
		Output.writeToFile("0 lt { 360 add } if");
		Output.writeToFile("} def");
		Output.writeToFile("/Forward {");
		Output.writeToFile("dup  Heading sin mul");
		Output.writeToFile("exch Heading cos mul");
		Output.writeToFile("2 copy Newposition");
		Output.writeToFile("rlineto");
		Output.writeToFile("} def");
		Output.writeToFile("/Newposition {");
		Output.writeToFile("Heading 180 gt Heading 360 lt");
		Output.writeToFile("and { neg } if exch");
		Output.writeToFile("Heading  90 gt Heading 270 lt");
		Output.writeToFile("and { neg } if exch");
		Output.writeToFile("Ypos add /Ypos exch def");
		Output.writeToFile("Xpos add /Xpos exch def");
		Output.writeToFile("} def");

		// This line is here for debugging purposes
		//System.out.println("[ OUR CODE SHOULD APPEAR BELOW HERE]");
	}

    /**
     * This method prints out the final code in PS required to make the output
     * as desired
     * (Also passes a String to the 'printer' to tell it to close the output stream)
     */
	public static void psEpilogue() {
		// This line is here for debugging purposes
		//System.out.println("[OUR CODE SHOULD APPEAR ABOVE HERE]");  


		/* epilogue ... */
		Output.writeToFile("Xpos Ypos moveto");
		//Call Main to start
		Output.writeToFile("MAIN");
		Output.writeToFile("stroke");
		Output.writeToFile("showpage");
		Output.writeToFile("EOF-CLOSE_STREAM");
	}
}
