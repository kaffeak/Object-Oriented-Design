package Controller;

import Model.*;
import Integration.*;

public class Controller {
    private ExternalAccountingSystem accountingSystem;
    private ExternalInventorySystem inventorySystem;
    private ReceiptPrinter printer;
    private DiscountDB discount;
    private Sale sale;
    private AddToSaleInfo saleInfo;
    
    public Controller(ExternalAccountingSystem accountingSystem, ExternalInventorySystem inventorySystem, ReceiptPrinter printer, DiscountDB discount){
        this.discount = discount;
        this.accountingSystem = accountingSystem;
        this.inventorySystem = inventorySystem;
        this.printer = printer;
    }
    
    public void startSale(){
        sale = new Sale();
    }

    public void addItem(int quantity, int itemID){
        sale.addToSale(inventorySystem.getItem(itemID), quantity);
    }

    public float endSale(){
        printer.printReceipt(sale);
        return sale.getRunningTotal();
    }

    public float retrieveDiscount(int customerId){
        return discount.getDiscounts(customerId, sale);
    }

    public float getChange(){
        return 0;
    }
    
}