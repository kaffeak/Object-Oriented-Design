package Integration;

import java.util.ArrayList;
import java.util.Random;

import Model.Sale;

public class DiscountDB {
    Random rand = new Random();
    public DiscountDB(){}

    public float getDiscounts(int customerId, Sale currentSale){
        float totalAfterDiscounts = itemDiscount(currentSale.getItems());
        totalAfterDiscounts = totalAfterDiscounts * personalDiscount(customerId);
        totalAfterDiscounts = totalAfterDiscounts * totalPriceDiscount(currentSale.getRunningTotal());
        return totalAfterDiscounts;
    }

    //This function would return a discount connected to the specific customer
    private float personalDiscount(int customerId){
        return 0.5f;//new Random(customerId).nextFloat(0.5f); 
    }
    //This function would return a discount based on specific items
    private float itemDiscount(ArrayList<ItemDTO> items){
        float totalItemsPrice = 0;
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
    private float totalPriceDiscount(float runningTotal){
        return 0.5f;//new Random(Float.floatToIntBits(runningTotal)).nextFloat(0.5f);
    }
}