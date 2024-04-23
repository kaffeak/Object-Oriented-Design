package Startup;

import Integration.DiscountDB;

public class Main {
    public static void main(String[] args){
        DiscountDB discounts = new DiscountDB();
        ExternalAccountingSystem accountingSystem = new ExternalAccountingSystem();
        ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        
    }
}
