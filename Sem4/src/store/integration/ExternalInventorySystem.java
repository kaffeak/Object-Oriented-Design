package store.integration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
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
                info = scanner.nextLine().split(",");
                itemDTO = new ItemDTO(Integer.parseInt(info[0]), info[1], Float.parseFloat(info[2]), Float.parseFloat(info[3]), info[4]);
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
     * @param items The <code>ItemDTO</code> list that will update the inventory with.
     */
    public void updateInventory(List<ItemDTO> items){
        //get items from External inventory system regarding provided list
        //count quantity of each item in provided list
        //push changes to External inventory system
        Set<ItemDTO> st = new HashSet<ItemDTO>(items);
        for (ItemDTO s : st)
            System.out.println("Told external inventory system to decrease inventory quantity of item " + s.getItemID() + " by " + Collections.frequency(items, s) + " units");
    }

    /**
     * Returns an {@link ItemDTO} from the inventory based on an itemID. 
     * 
     * @param ItemID The itemId used to search in the inventory for an <code>ItemDTO</code>.
     * @return The <code>ItemDTO</code> of the item with the corresponding itemID or null if not found.
     */
    public ItemDTO getItem(int ItemID) throws ItemNotFoundException, DatabaseFailureException {
        if(ItemID == 1337){
            throw new DatabaseFailureException("Database can not be reached");
        }
        try {
            return inventoryItems.get(ItemID);
        } catch (IndexOutOfBoundsException ex){
            throw new ItemNotFoundException("Item could not be found " + ItemID);
        }
    }
}