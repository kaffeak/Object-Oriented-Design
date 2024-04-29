package View;

import Controller.Controller;

public class View {

    /*Controller contr;

    public View(Controller contr){
        this.contr = contr;
    }*/

    public View(Controller contr){
        contr.startSale();
        contr.addItem(10, 0);
        contr.addItem(3, 3);
        contr.addItem(2, 2);
        contr.addItem(3, 1);
        contr.addItem(1, 0);
        System.out.println(contr.endSale());
    }
}
