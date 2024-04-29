package store.integration;

/**
 * Represents the information about a store item
 */
public class ItemDTO {

    private int itemID;
    private float VAT;
    private String name;
    private float price;

    /**
     * Creates a new instance of ItemDTO, representing an item in the store system.
     * 
     * @param itemID The id represented by the newly created instance.
     * @param name The name represented by the newly created instance. 
     * @param price The price represented by the newly created instance.
     * @param VAT The VAT represented by the newly created instance.
     */
    public ItemDTO(int itemID, String name, float price, float VAT){
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
    }

    /**
     * Returns the id of the item.
     * 
     * @return Returns the id of the item.
     */
    public int getItemID(){
        return this.itemID;
    }

    /**
     * Returns the name of the item.
     * 
     * @return Returns the name of the item.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the price of the item.
     * 
     * @return Returns the price of the item.
     */
    public float getPrice(){
        return this.price;
    }

    /**
     * Returns the VAT of the item.
     * 
     * @return Returns the VAT of the item.
     */
    public float getVAT(){
        return this.VAT;
    }
}