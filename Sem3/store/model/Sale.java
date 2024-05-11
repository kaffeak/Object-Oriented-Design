package store.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import store.integration.ItemDTO;


/**
 * Represents the ongoing sale.
 */
public class Sale {
    private Timestamp timestamp;
    private float runningTotal;
    private float totalVAT;
	private List<Entry<ItemDTO, Integer>> items;
    //private ArrayList<ItemDTO> items;

    /**
     * Creates a new instance of Sale.
     * 
     */
    public Sale(){
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.runningTotal = 0;
        this.totalVAT = 0;
        this.items = new ArrayList<Entry<ItemDTO, Integer>>();
    }

    /**
     * Adds an {@link ItemDTO} to the sale object and increases the 
     * running total of the sale. It returns an {@link AddToSaleInfo} 
     * instance with the current running total and the added {@link ItemDTO}. 
     * 
     * @param item The <code>ItemDTO</code> to be added to the sale.
     * @param quantity The amount of items that should be added to sale.
     * @return The <code>AddToSaleInfo</code> containing information about 
     *         the last added item and the running total for the sale.
     */
    public AddToSaleInfo addToSale(ItemDTO item, int quantity){
		boolean exists = false;
		for (Entry<ItemDTO,Integer> entry : items) {
			if (entry.getKey().getItemID() == item.getItemID()) 
			{
				exists = true;
				System.out.println(entry.getValue());
				entry.setValue(entry.getValue() + quantity);
				break;
			}
		}     
			if (!exists) {
				Entry<ItemDTO,Integer> newItem = new SimpleEntry<>(item, quantity);
				this.items.add(newItem);
			} 
            this.runningTotal += quantity * item.getPrice() * ((item.getVAT()/100) + 1);
            this.totalVAT +=  quantity * item.getPrice() * item.getVAT()/100;
        return getAddToSaleInfo(item);
    }
    private AddToSaleInfo getAddToSaleInfo(ItemDTO item){
        return new AddToSaleInfo(item, this.runningTotal, this.totalVAT);
    }

    /**
     * Returns the list of {@link ItemDTO} and thier amount in sale.
     * 
     * @return The list of <code>ItemDTO</code> and thier amount in sale.
     */
    public List<Entry<ItemDTO,Integer>> getItems() {
        return items;
    }

    /**
     * Returns the timestamp from when the sale started.
     * 
     * @return The timestamp from when the sale started.
     */
    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    /**
     * Returns the running total for the sale.
     * 
     * @return The running total for the sale.
     */
    public float getRunningTotal() {
        return runningTotal;
    }

    /**
     * Returns the total VAT for the sale.
     * 
     * @return The total VAT for the sale.
     */
    public float getTotalVAT(){
        return this.totalVAT;
    }

    /**
     * Sets the value for running total
     * 
     */
    public void setRunningTotal(float newRunningTotal) {
        this.runningTotal = newRunningTotal;
    }
}
