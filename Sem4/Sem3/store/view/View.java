package store.view;

import store.model.AddToSaleInfo;
import store.controller.Controller;
import store.integration.DatabaseFailureException;
import store.integration.ItemNotFoundExeption;

 /**
 * Represents the store systems View part
 */
public class View {
    /**
     * Creates a new instance of view.
     * 
     * @param contr The instance of controller being used by 
     *              the newly created instance.
     * @throws ItemNotFoundExeption 
     * @throws DatabaseFailureException 
     */
    public View(Controller contr) throws DatabaseFailureException, ItemNotFoundExeption{ 
        AddToSaleInfo temp;
        contr.startSale();
        temp = contr.addItem(0, 10);
        System.out.println("Add 10 items with item id 0:\n" +
                       "Item ID: " + temp.getItem().getItemID() +
                       "\nItem name: " + temp.getItem().getName() +
                       "\nItem cost: " + (temp.getItem().getPrice() * (1+(temp.getItem().getVAT()/100))) + " SEK\n" +
                       "VAT: " + temp.getItem().getVAT() + "%\n" +
                       "Item description: " + temp.getItem().getItemDescription() +
                       "\n\nTotal cost (incl VAT): " + temp.getRunningTotal() + " SEK\n" +
                       "Total VAT: " + temp.getTotalVAT() + " SEK\n");
        temp = contr.addItem(3, 3);
        System.out.println("Add 3 items with item id 3:\n" +
                       "Item ID: " + temp.getItem().getItemID() +
                       "\nItem name: " + temp.getItem().getName() +
                       "\nItem cost: " + (temp.getItem().getPrice() * (1+(temp.getItem().getVAT()/100))) + " SEK\n" +
                       "VAT: " + temp.getItem().getVAT() + "%\n" +
                       "Item description: " + temp.getItem().getItemDescription() +
                       "\n\nTotal cost (incl VAT): " + temp.getRunningTotal() + " SEK\n" +
                       "Total VAT: " + temp.getTotalVAT() + " SEK\n");
        temp = contr.addItem(2, 2);
        System.out.println("Add 2 items with item id 2:\n" +
                       "Item ID: " + temp.getItem().getItemID() +
                       "\nItem name: " + temp.getItem().getName() +
                       "\nItem cost: " + (temp.getItem().getPrice() * (1+(temp.getItem().getVAT()/100))) + " SEK\n" +
                       "VAT: " + temp.getItem().getVAT() + "%\n" +
                       "Item description: " + temp.getItem().getItemDescription() +
                       "\n\nTotal cost (incl VAT): " + temp.getRunningTotal() + " SEK\n" +
                       "Total VAT: " + temp.getTotalVAT() + " SEK\n");
        temp = contr.addItem(1, 3);
        System.out.println("Add 3 items with item id 1:\n" +
                       "Item ID: " + temp.getItem().getItemID() +
                       "\nItem name: " + temp.getItem().getName() +
                       "\nItem cost: " + (temp.getItem().getPrice() * (1+(temp.getItem().getVAT()/100))) + " SEK\n" +
                       "VAT: " + temp.getItem().getVAT() + "%\n" +
                       "Item description: " + temp.getItem().getItemDescription() +
                       "\n\nTotal cost (incl VAT): " + temp.getRunningTotal() + " SEK\n" +
                       "Total VAT: " + temp.getTotalVAT() + " SEK\n");
        temp = contr.addItem(0, 1);
        System.out.println("Add 1 items with item id 0:\n" +
                       "Item ID: " + temp.getItem().getItemID() +
                       "\nItem name: " + temp.getItem().getName() +
                       "\nItem cost: " + (temp.getItem().getPrice() * (1+(temp.getItem().getVAT()/100))) + " SEK\n" +
                       "VAT: " + temp.getItem().getVAT() + "%\n" +
                       "Item description: " + temp.getItem().getItemDescription() +
                       "\n\nTotal cost (incl VAT): " + temp.getRunningTotal() + " SEK\n" +
                       "Total VAT: " + temp.getTotalVAT() + " SEK\n");
        System.out.println("End Sale:\n" + 
                           "Total cost (incl VAT) " + contr.endSale() + " SEK\n");
        System.out.println("\nChange to give to the customer: " + contr.getChange(500) + " SEK\n");

        
    }

    
}
