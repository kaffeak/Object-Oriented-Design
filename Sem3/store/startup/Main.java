package store.startup;

import store.integration.*;
import store.view.View;
import store.controller.Controller;

public class Main {
    public static void main(String[] args){
        DiscountDB discounts = new DiscountDB();
        ExternalAccountingSystem accountingSystem = new ExternalAccountingSystem();
        ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        ReceiptPrinter printer = new ReceiptPrinter();
        Controller contr = new Controller(accountingSystem, inventorySystem, printer, discounts);
        View view = new View(contr);
    }
}
