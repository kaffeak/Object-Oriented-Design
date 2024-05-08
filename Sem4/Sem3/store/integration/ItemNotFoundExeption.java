package store.integration;

public class ItemNotFoundExeption extends Exception {
    int itemID;

    public ItemNotFoundExeption(int itemID){
        super("This item does not exist. ID:" + itemID);
        this.itemID = itemID;
    }



    public ItemNotFoundExeption(String msg){
        super(msg);
    }
}
