package store.integration;

/**
 * Exception that handles unavailability to the database when requested
 */
public class DatabaseFailureException extends Exception {
    public DatabaseFailureException(String msg){
        super(msg);
    }
}
