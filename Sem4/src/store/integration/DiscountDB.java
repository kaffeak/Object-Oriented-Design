package store.integration;

import java.util.ArrayList;
import java.util.Random;

import store.model.Sale;

/**
 * Represents the store systems discount database part
 */
public class DiscountDB {

    /**
    * Represents the store systems external accounting part
    */
    Random rand = new Random();
    public DiscountDB(){}

    /**
     * Calculates the running total for the sale after discounts 
     * have been accounted for. The discounts are based on the customer
     * id, items in and running total of the {@link Sale}.
     * 
     * @param customerID The id of the customer.
     * @param currentSale The <code>Sale</code> that the discounts will be based on.
     * @return The new running total of the sale.
     */
    public double getDiscounts(int customerID, Sale currentSale){
        double totalAfterDiscounts = itemDiscount(currentSale.getItems());
        totalAfterDiscounts = totalAfterDiscounts * personalDiscount(customerID);
        totalAfterDiscounts = totalAfterDiscounts * totalPriceDiscount(currentSale.getRunningTotal());
        return totalAfterDiscounts;
    }

    //This function would return a discount connected to the specific customer
    private double personalDiscount(int customerID){
        return 0.5f;//new Random(customerID).nextFloat(0.5f); 
    }
    //This function would return a discount based on specific items
    private double itemDiscount(ArrayList<ItemDTO> items){
        double totalItemsPrice = 0;
        for (ItemDTO item : items){
            if (isItemDiscounted(item)) 
                totalItemsPrice += (item.getPrice()); //* new Random().nextFloat(0.5f)) * (item.getVAT()+1);
        }
        return 0.5f;//totalItemsPrice; 
    }
    private boolean isItemDiscounted(ItemDTO item){
        return new Random().nextBoolean();
    }
    //This function would return a discount based on the price
    private double totalPriceDiscount(double runningTotal){
        return 0.5f;//new Random(Float.floatToIntBits(runningTotal)).nextFloat(0.5f);
    }
}