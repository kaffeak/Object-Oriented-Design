package store.integration;

import store.model.Sale;
/**
 * Represents the store systems external accounting part
 */
public class ExternalAccountingSystem {

    /**
    * Represents the store systems external accounting part
    */
    public ExternalAccountingSystem(){}

    /**
     * Sends a {@link Sale} to the accounting system for accounting. 
     * 
     * @param sale The <code>Sale</code> that should be accounted.
     */
    public void sendToAccounting(Sale sale){
        //Send info about sale to accounting
    }

    /**
     * Calculates the change that the customer should be returned based on 
     * {@link Sale} and the amount paid. 
     * 
     * @param amountPaid The amount paid by the customer.
     * @param runningTotal The running total of the sale.
     * @return The change that the customer shuld get back.
     */
    public float getChange(int amountPaid, float runningTotal){
        return ((float) amountPaid - runningTotal);
    }
}
