package store.model;

import store.integration.ItemDTO;
/**
 * Represents the information about an item and the 
 * total running price for a sale
 */
public class AddToSaleInfo {
    private ItemDTO item;
    private double runningTotal;
    private double totalVAT;

    /**
     * Creates a new instance of AddToSaleInfo, representing 
     * the last added item, the running total and the total VAT of the sale.
     * 
     * @param item The <code>ItemDTO</code> represented by the newly created instance.
     * @param runningTotal The running total represented by the newly created instance.
     * @param totalVAT The total VAT representad by the newly created instance.
     */
    public AddToSaleInfo(ItemDTO item, double runningTotal, double totalVAT){
        this.item = item;
        this.runningTotal = runningTotal;
        this.totalVAT = totalVAT;
    }

    /**
     * Returns the {@link ItemDTO} in the object.
     * 
     * @return The <code>ItemDTO</code> in the object.
     */
    public ItemDTO getItem() {
        return item;
    }

   /**
     * Returns the running total in the object.
     * 
     * @return The running total in the object.
     */
    public double getRunningTotal() {
        return runningTotal;
    }

    /**
     * Returns the running total in the object.
     * 
     * @return The running total in the object.
     */
    public double getTotalVAT(){
        return totalVAT;
    }
}
