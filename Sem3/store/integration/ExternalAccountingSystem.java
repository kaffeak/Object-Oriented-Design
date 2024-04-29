package store.integration;

import store.model.Sale;

public class ExternalAccountingSystem {
    public ExternalAccountingSystem(){}
    public void sendToAccounting(Sale sale){
        //Send info about sale to accounting
    }
    public float getChange(int amountPaid, Sale sale){
        return ((float) amountPaid - sale.getRunningTotal());
    }
}
