package logoCompiler;

import java.io.PrintWriter;

/**
 * This class deals with all the data that goes out from the compiler program
 */
public class Output {

    private static String finalDestination = "";
    private static PrintWriter write;

    /**
     * This is called at the beginning of the program to decide where to write any content to
     * @param destination The filename that the content will be written to (will be .ps format)
     */
    public static void setOutput(String destination){
        finalDestination = destination;
        try{
            write = new PrintWriter(finalDestination);
        }
        catch (java.io.FileNotFoundException e){
            writeToConsole("Error when setting up the file to write to: " + e);
        }
    }

    /**
     * This method is used if there is content that is not to be put to the file
     * (for exampe error messages that are to be displayed to the user but not exit the
     * compiler as code for PS to try and read)
     * @param content The content to be placed in the console.
     */
    public static void writeToConsole(String content){
        System.out.println(content);
    }

    /**
     * This is the method that actually outputs the information to the file given.
     * (Provided that that content doesn't match the string set out to close the file stream.)
     * @param content The content that is to be written to file.
     */
    public static void writeToFile(String content){

            if(content.equals("EOF-CLOSE_STREAM")){
                write.close();
            }
            write.println(content);
    }
}