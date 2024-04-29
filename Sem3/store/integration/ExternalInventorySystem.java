package store.integration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * Represents the store systems external inventory part
 */
public class ExternalInventorySystem {
    private ItemDTO itemDTO;
    private List<ItemDTO> inventoryItems = new ArrayList<>();

    /**
     * Creates a new instance of ExternalInventorySystem.
     * 
     */
    public ExternalInventorySystem() {
        try {
            File inventory = new File("store/integration/inventoryItems.txt");
            Scanner scanner = new Scanner(inventory);
            String[] info;
            int i = 0;
            while (scanner.hasNextLine()) {
                info = scanner.nextLine().split(" ");
                itemDTO = new ItemDTO(Integer.parseInt(info[0]), info[1], Float.parseFloat(info[2]), Float.parseFloat(info[3]));
                inventoryItems.add(itemDTO);
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
    }

    /**
     * Updates the inventory status based on an {@link ItemDTO} list. 
     * 
     * @param item The <code>ItemDTO</code> list that will update the inventory with.
     */
    public void updateInventory(List<ItemDTO> items){
        //get items from External inventory system regarding provided list
        //count quantity of each item in provided list
        //push changes to External inventory system
    }

    /**
     * Returns an {@link ItemDTO} from the inventory based on an itemID. 
     * 
     * @param itemID The itemId used to search in the inventory for an <code>ItemDTO</code>.
     * @return The <code>ItemDTO</code> of the item with the corresponding itemID or null if not found.
     */
    public ItemDTO getItem(int ItemID){
        //Extract item information from external inventory system with provided ID
        //Return THIS item
        return inventoryItems.get(ItemID);
    }
}