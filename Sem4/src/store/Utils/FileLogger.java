package store.Utils;

import java.io.*;


public class FileLogger {
    File log;

    public FileLogger(String name){
        setFile(name);
    }
    public void writeToFile(String message){
        try(FileWriter writer = new FileWriter(log,true);
            BufferedWriter bWriter = new BufferedWriter(writer);
            PrintWriter filWriter = new PrintWriter(bWriter)){
                filWriter.println(message);
            }catch(IOException e){
                System.err.println("Error! Can't write to file");
                System.err.println(e);
            }
    }
    public void setFile(String name){
        log = new File(name);
    }
}
