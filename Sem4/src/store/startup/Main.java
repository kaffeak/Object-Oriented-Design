package store.startup;

import store.Utils.FileLogger;
import store.integration.*;
import store.view.View;
import store.controller.Controller;

/**
 * Represents the store systems Main startup part
 */
public class Main {
    /**
     * Starts the system and creates instances of all objects
     */
    public static void main(String[] args){
        DiscountDB discounts = new DiscountDB();
        ExternalAccountingSystem accountingSystem = new ExternalAccountingSystem();
        ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        ReceiptPrinter printer = new ReceiptPrinter();
        FileLogger logger = new FileLogger();
        Controller contr = new Controller(accountingSystem, inventorySystem, printer, discounts);
        View view = new View(contr, logger);
        view.testrun();
    }
}
