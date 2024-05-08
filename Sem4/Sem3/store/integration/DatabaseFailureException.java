package store.integration;

public class DatabaseFailureException extends RuntimeException {
    int itemCausingFailure;

    public DatabaseFailureException(int itemID){
        super("Database can not be contacted." + itemID +"Item caused a failure" );
        int itemCausingFailure = itemID;
    }

    public DatabaseFailureException(String msg){
        super(msg);
    }
}
