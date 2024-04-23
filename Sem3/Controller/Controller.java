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
    private View view;
    private AddToSaleInfo saleInfo;

    Controller cont = new Controller();
    
    public Controller(Sale sale, View view, ExternalAccountingSystem accountingSystem, ExternalInventorySystem inventorySystem, ReceiptPrinter printer, DiscountDB discount){
        this.sale = sale;
        this.discount = discount;
        this.accountingSystem = accountingSystem;
        this.inventorySystem = inventorySystem;
        this.printer = printer;
        this.view = view;
    }
    
    public void startSale(){
        sale = new Sale();
    }
    public void addItem(int quantity, int itemID){
        
    }
    public float endSale(){
        return sale.getRunningTotal();
    }
    public float retrieveDiscount(int customerId){
        return sale.get;
    }
    public float getChange(){

    }
    
}