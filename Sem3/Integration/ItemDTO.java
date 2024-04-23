package integration;

public class ItemDTO {

    private int itemID;
    private float VAT;
    private String name;
    private float price;

    public ItemDTO(int itemID, String name, float price, float VAT){
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
    }

    public int getItemID(){
        return this.itemID;
    }

    public String getName(){
        return this.name;
    }

    public float getPrice(){
        return this.price;
    }

    public float getVAT(){
        return this.VAT;
    }
    /*
    public static void main(String args[]){
        ItemDTO itemDTO = new ItemDTO(23, 1, "boat", 500);

        System.out.println(itemDTO.getItemID());
        System.out.println(itemDTO.getPrice());
        System.out.println(itemDTO.getVAT());
        System.out.println(itemDTO.getName());
    }*/
}