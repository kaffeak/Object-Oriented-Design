package store.view;

import store.model.AddToSaleInfo;
import store.controller.Controller;

public class View {

    /*Controller contr;

    public View(Controller contr){
        this.contr = contr;
    }*/

    public View(Controller contr){ //The view part of the system
        AddToSaleInfo temp;
        contr.startSale();
        temp = contr.addItem(10, 0);
        System.out.println("Item: " + temp.getItem().getName() + ", Total amount: " + temp.getRunningTotal());
        temp = contr.addItem(3, 3);
        System.out.println("Item: " + temp.getItem().getName() + ", Total amount: " + temp.getRunningTotal());
        temp = contr.addItem(2, 2);
        System.out.println("Item: " + temp.getItem().getName() + ", Total amount: " + temp.getRunningTotal());
        temp = contr.addItem(3, 1);
        System.out.println("Item: " + temp.getItem().getName() + ", Total amount: " + temp.getRunningTotal());
        temp = contr.addItem(1, 0);
        System.out.println("Item: " + temp.getItem().getName() + ", Total amount: " + temp.getRunningTotal());
        System.out.println(contr.endSale());
        contr.getChange(500);
    }
}
