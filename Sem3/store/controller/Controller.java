package store.controller;

import store.integration.*;
import store.model.*;

public class Controller {
    private ExternalAccountingSystem accountingSystem;
    private ExternalInventorySystem inventorySystem;
    private ReceiptPrinter printer;
    private DiscountDB discount;
    private Sale sale;
    
    public Controller(ExternalAccountingSystem accountingSystem, ExternalInventorySystem inventorySystem, ReceiptPrinter printer, DiscountDB discount){
        this.discount = discount;
        this.accountingSystem = accountingSystem;
        this.inventorySystem = inventorySystem;
        this.printer = printer;
    }
    
    public void startSale(){
        sale = new Sale();
    }

    public AddToSaleInfo addItem(int quantity, int itemID){
        return sale.addToSale(inventorySystem.getItem(itemID), quantity);
    }

    public float endSale(){
        return sale.getRunningTotal();
    }

    public float retrieveDiscount(int customerId){
        return discount.getDiscounts(customerId, sale);
    }

    public float getChange(int amountPaid){
        float change = accountingSystem.getChange(amountPaid, sale);
        accountingSystem.sendToAccounting(sale);
        inventorySystem.updateInventory(sale.getItems());
        printer.printReceipt(sale, amountPaid, change);
        return change;
    }
    
}