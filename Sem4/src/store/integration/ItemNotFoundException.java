package store.integration;

public class ItemNotFoundException extends Exception {
    int itemID;

    public ItemNotFoundException(int itemID){
        super("This item does not exist. ID:" + itemID);
        this.itemID = itemID;
    }



    public ItemNotFoundException(String msg){
        super(msg);
    }
}
