package store.Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * This class exist to enable logging of exceptions
 */
public class FileLogger implements Logger{
    private static final String fileSrc = "store/view/errorLog.txt";
    private PrintWriter pw;

    /**
     * Method that creates a new instance of file logger
     */
    public FileLogger(){
        try {
            pw = new PrintWriter(new FileWriter(fileSrc), true);
        }catch (IOException ex) {
            System.out.println("File logger could not be initiated");
            ex.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Method that logs the exception to given file
     */
    @Override
    public void log(Exception ex){
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------------------\n");
        sb.append(ex.toString()).append("\n");
        sb.append("Error occured at: ").append(new Timestamp(System.currentTimeMillis())).append("\n");
        sb.append("Stacktrace: ").append(ex.getStackTrace()[0].toString()).append("\n");
        sb.append("-------------------------------------------\n");
        pw.println(sb);
    }
}
