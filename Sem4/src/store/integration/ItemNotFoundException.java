package store.integration;

/**
 * Exception that handles an item not currently available to retrieve from EIS
 */
public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(String msg){
        super(msg);
    }
}
