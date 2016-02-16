package logoCompiler;

import java.io.PrintWriter;

public class Output {

    private static String finalDestination = "";
    private static PrintWriter write;

    public static void setOutput(String destination){
        finalDestination = destination;
        try{
            write = new PrintWriter(finalDestination);
        }
        catch (java.io.FileNotFoundException e){
            writeToConsole("Error when setting up the file to write to: " + e);
        }
    }

    public static void writeToConsole(String content){
        System.out.println(content);
    }

    public static void writeToFile(String content){

            if(content.equals("EOF-CLOSE_STREAM")){
                write.close();
            }
            write.println(content);
    }
}