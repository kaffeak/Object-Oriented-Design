import Integration.ItemDTO;
import java.util.List;

public class ExternalInventorySystem {
    private ItemDTO item;

    public ExternalInventorySystem() {
    }

    public void updateInventory(List<ItemDTO> items){
        //get items from External inventory system regarding provided list
        //count quantity of each item in provided list
        //push changes to External inventory system
    }

    public ItemDTO getItem(int ItemID){
        //Extract item information from external inventory system with provided ID
        //Return THIS item
    }

}