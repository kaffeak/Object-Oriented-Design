package store.view;

import store.model.AddToSaleInfo;
import store.controller.Controller;

 /**
 * Represents the store systems View part
 */
public class View {
    /**
     * Creates a new instance of view.
     * 
     * @param contr The instance of controller being used by 
     *              the newly created instance.
     */
    public View(Controller contr){ 
        AddToSaleInfo temp;
        contr.startSale();
        temp = contr.addItem(0, 10);
        System.out.println("Item: " + temp.getItem().getName() + ", Total amount: " + temp.getRunningTotal());
        temp = contr.addItem(3, 3);
        System.out.println("Item: " + temp.getItem().getName() + ", Total amount: " + temp.getRunningTotal());
        temp = contr.addItem(2, 2);
        System.out.println("Item: " + temp.getItem().getName() + ", Total amount: " + temp.getRunningTotal());
        temp = contr.addItem(1, 3);
        System.out.println("Item: " + temp.getItem().getName() + ", Total amount: " + temp.getRunningTotal());
        temp = contr.addItem(0, 1);
        System.out.println("Item: " + temp.getItem().getName() + ", Total amount: " + temp.getRunningTotal());
        System.out.println(contr.endSale());
        contr.getChange(500);
    }
}
