package store.controller;

import store.integration.*;
import store.model.*;

public class Controller {
    private ExternalAccountingSystem accountingSystem;
    private ExternalInventorySystem inventorySystem;
    private ReceiptPrinter printer;
    private DiscountDB discount;
    private Sale sale;
    
    /**
     * Creates a new instance of Controller, representing an the controller in the store system.
     * 
     * @param accountingSystem The <code>ExternalAccountingSystem</code> represented by the newly created instance.
     * @param inventorySystem The <code>ExternalInventorySystem</code> represented by the newly created instance. 
     * @param printer The <code>ReceiptPrinter</code> represented by the newly created instance.
     * @param discount The <code>DiscountDB</code> represented by the newly created instance.
     */
    public Controller(ExternalAccountingSystem accountingSystem, ExternalInventorySystem inventorySystem, ReceiptPrinter printer, DiscountDB discount){
        this.discount = discount;
        this.accountingSystem = accountingSystem;
        this.inventorySystem = inventorySystem;
        this.printer = printer;
    }
    
    /**
     * Starts a new sale
     */
    public void startSale(){
        this.sale = new Sale();
    }

    /**
     * Adds an {@link ItemDTO} to the sale object. It returns an {@link AddToSaleInfo} 
     * instance with the current running total and the added {@link ItemDTO}. 
     * 
     * @param item The <code>ItemDTO</code> to be added to the sale.
     * @param quantity The amount of items that should be added to sale.
     * @return The <code>AddToSaleInfo</code> containing information about 
     *         the last added item and the running total for the sale.
     */
    public AddToSaleInfo addItem(int itemID, int quantity){
        return sale.addToSale(inventorySystem.getItem(itemID), quantity);
    }

    /**
     * Ends the sale and returns the running total of the sale.
     * 
     * @return The running total for the sale.
     */
    public double endSale(){
        return sale.getRunningTotal();
    }

    /**
     * Adds discount to the sale, updates the new running total and returns the new running total. 
     * 
     * @param customerID The customer id that will be used to check for discounts.
     * @return The new running total for the sale.
     */
    public double retrieveDiscount(int customerID){
        double newRunningTotal = discount.getDiscounts(customerID, sale);
        sale.setRunningTotal(newRunningTotal);
        return newRunningTotal;
    }

    /**
     * Calculates the change that the customer should get back based on the
     * amount paid and the running total of the sale. It also sends the 
     * information to the accounting system, updates the inventory system,
     * prints a receipt and updates the registry.
     * 
     * @param amountPaid The amount paid by the customer.
     * @return The amount that the customer should get back.
     */
    public double getChange(int amountPaid){
        double change = accountingSystem.getChange(amountPaid, sale.getRunningTotal());
        accountingSystem.sendToAccounting(sale);
        inventorySystem.updateInventory(sale.getItems());
        printer.printReceipt(sale, amountPaid, change);
        //update registry
        return change;
    }
    
}