package Controller;

import Model.AddToSaleInfo;
import Model.Sale;
import Integration.DiscountDB;
import Integration.ItemDTO;

public class Controller {
    private ExternalAccountingSystem accountingSystem;
    private ExternalInventorySystem inventorySystem;
    private ReceiptPrinter printer;
    private DiscountDB discount;
    private Sale sale;
    private AddToSaleInfo saleInfo;

    Controller cont = new Controller();
    
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
        sale.addToSale(null, quantity);
    }
    public float endSale(){
        return sale.getRunningTotal();
    }
    public float retrieveDiscount(int customerId){
        return discount.getDiscounts(customerId, sale);
    }
    public float getChange(){

    }
    
}