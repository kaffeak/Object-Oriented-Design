package Model;

import Integration.ItemDTO;
import java.sql.Timestamp;
import java.util.ArrayList;


/**
 * Sale
 */
public class Sale {
    private Timestamp timestamp;
    private float runningTotal;
    private ArrayList<ItemDTO> items;
    
    public Sale(){
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.runningTotal = 0;
        this.items = new ArrayList<ItemDTO>();
    }
    public void addToSale(ItemDTO item, int quantity){
        while (quantity-- > 0){
            this.items.add(item);
            this.runningTotal += item.getPrice() + item.getPrice() * item.getVAT();
        }
    }
    public AddToSaleInfo getAddToSaleInfo(){
        return new AddToSaleInfo(this.items.get(this.items.size()-1), this.runningTotal);
    }
    public ArrayList<ItemDTO> getItems() {
        return this.items;
    }
    public Timestamp getTimestamp() {
        return this.timestamp;
    }
    public float getRunningTotal() {
        return runningTotal;
    }
}
