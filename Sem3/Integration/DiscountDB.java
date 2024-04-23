package Integration;

import java.util.ArrayList;
import java.util.Random;

import Model.Sale;
import Integration.ItemDTO;

public class DiscountDB {
    public DiscountDB(){}

    public float getDiscounts(int customerId, Sale currentSale){
        float totalAfterDiscounts = itemDiscount(currentSale.getItems());
        totalAfterDiscounts = totalAfterDiscounts * personalDiscount(customerId);
        totalAfterDiscounts = totalAfterDiscounts * totalPriceDiscount(currentSale.getRunningTotal());
        return totalAfterDiscounts;
    }

    //This function would return a discount connected to the specific customer
    private float personalDiscount(int customerId){
        return new Random(customerId).nextFloat(0.5f); 
    }
    private float itemDiscount(ArrayList<ItemDTO> items){
        float totalItemsPrice = 0;
        for (ItemDTO item : items){
            if (isItemDiscounted(item)) 
                totalItemsPrice += (item.getPrice() * new Random().nextFloat(0.5f)) * (item.getVAT()+1);
        }
        return totalItemsPrice; 
    }
    private boolean isItemDiscounted(ItemDTO item){
        return new Random().nextBoolean();
    }
    private float totalPriceDiscount(float runningTotal){
        return new Random(Float.floatToIntBits(runningTotal)).nextFloat(0.5f);
    }
}