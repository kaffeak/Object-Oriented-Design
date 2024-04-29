package store.model;

import store.integration.ItemDTO;
/**
 * Represents the information about an item and the 
 * total running price for a sale
 */
public class AddToSaleInfo {
    private ItemDTO item;
    private float runningTotal;

    /**
     * Creates a new instance of AddToSaleInfo, representing 
     * the last added item and the running total of the sale.
     * 
     * @param item The <code>ItemDTO</code> represented by the newly created instance.
     * @param runningTotal The running total represented by the newly created instance.
     */
    public AddToSaleInfo(ItemDTO item, float runningTotal){
        this.item = item;
        this.runningTotal = runningTotal;
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
    public float getRunningTotal() {
        return runningTotal;
    }
}
