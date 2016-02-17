package filereading;

import logoCompiler.Output;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * This class is used to read the content of the validated for ".t" type input file into working memory
 */
public class FileReader {
	public static Reader reader;
	public static BufferedReader buffer;

    /**
     * This method is used to return the int of the next char in the buffer
     * @return The chars int.
     */
	public static int getChar() {
		try {
			return buffer.read();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return -1;
	}
	/*
	 * http://stackoverflow.com/questions/811851/
	 */

    /**
     * This is the method that reads the file in
     * @param input The string of the fileName about to be read
     * @return a Reader Object containing the read in data.
     */
	public static Reader read(String input){
		File file = new File(input);
		InputStream in;
		try {
			in = new FileInputStream(file);
			reader = new InputStreamReader(in);
			buffer = new BufferedReader(reader);

			return buffer;
		} catch (FileNotFoundException e) {
			Output.writeToConsole("Error 404: input file not found, since nothing can be done" +
					" without a source file: compiler terminating.");
			System.exit(0);
		}
		
		return null;
	}

}