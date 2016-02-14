package filereading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileReader {
	public static Reader reader;
	public static BufferedReader buffer;
	
	public static int getChar() {
		try {
			return buffer.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return -1;
	}
	/*
	 * http://stackoverflow.com/questions/811851/
	 */
	public static Reader read() {
		File file = new File("LogoPrograms/dragon_backup.t");
		InputStream in;
		try {
			in = new FileInputStream(file);
			reader = new InputStreamReader(in);
			buffer = new BufferedReader(reader);

			return buffer;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		}
		
		return null;
	}

}
