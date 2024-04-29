package store.model;

import java.sql.Timestamp;
import java.util.ArrayList;

import store.integration.ItemDTO;


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
    public AddToSaleInfo addToSale(ItemDTO item, int quantity){
        while (quantity-- > 0){
            this.items.add(item);
            this.runningTotal += item.getPrice() * ((item.getVAT()/100) + 1);
        }
        return getAddToSaleInfo();
    }
    private AddToSaleInfo getAddToSaleInfo(){
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
