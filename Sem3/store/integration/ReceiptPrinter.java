package store.integration;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import store.model.Sale;
/**
 * Represents the store systems receipt printer
 */
public class ReceiptPrinter {
    private List<ItemDTO> items;

    /**
     * Creates a new instance of ReceiptPrinter.
     * 
     */
    public ReceiptPrinter(){}

    /**
     * Prints out a receipt based on the {@link Sale} to the sale. 
     * 
     * @param sale The <code>Sale</code> that should be printed.
     * @param amount The amount paid by the customer.
     * @param change The amount of change the customer got back.
     */
    public void printReceipt(Sale sale, int amountPaid, float change){
        StringBuilder sb = new StringBuilder();
        sb.append("\n--------------Begin receipt--------------" + "\n");
        sb.append("Time of sale:" + sale.getTimestamp() + "\n\n");

        List<Entry<ItemDTO,Integer>> items = sale.getItems();
		for (Entry<ItemDTO,Integer> entry : items) {
			sb.append(entry.getKey().getName() + "\t\t" + entry.getValue() + " x " + ((1+(entry.getKey().getVAT()/100)) * entry.getKey().getPrice()) + "\t" + (entry.getValue()*(((1+(entry.getKey().getVAT()/100)) * entry.getKey().getPrice()))) + " SEK\n");
		}
        sb.append("Total:\t\t\t\t" + sale.getRunningTotal() + " SEK\n");
        sb.append("VAT: " + sale.getTotalVAT());
        sb.append("\n\nCash:\t\t\t\t" + amountPaid + " SEK\n");
        sb.append("Change:\t\t\t\t" + change + " SEK\n");
        sb.append("---------------End receipt---------------" + "\n");
        System.out.println(sb.toString());
    }
}
