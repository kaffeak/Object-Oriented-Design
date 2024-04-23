package Model;

import Integration.ItemDTO;

public class AddToSaleInfo {
    private ItemDTO item;
    private float runningTotal;
    public AddToSaleInfo(ItemDTO item, float runningTotal){
        this.item = item;
        this.runningTotal = runningTotal;
    }
    public ItemDTO getItem() {
        return item;
    }
    public float getRunningTotal() {
        return runningTotal;
    }
}
