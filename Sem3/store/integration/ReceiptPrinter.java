package store.integration;

import java.util.List;

import store.model.Sale;

public class ReceiptPrinter {
    private List<ItemDTO> items;

    public ReceiptPrinter(){}

    public void printReceipt(Sale sale, int amountPaid, float change){
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------" + "\n");
        sb.append("Item: | Price(SEK) | VAT(%)" + "\n");
        sb.append("---------------------------" + "\n");

        items = sale.getItems();
        ItemDTO item;
        int i = items.size();
        while (i-- > 0){
            item = items.get(i);
            sb.append(item.getName() + " " + item.getPrice() + " " + item.getVAT() + "\n");
        }
        sb.append("---------------------------" + "\n");
        sb.append("Total:" + "\n");
        sb.append(sale.getRunningTotal() + "\n" + "\n");
        sb.append("Amount paid:" + "\n");
        sb.append(amountPaid + "\n" + "\n");
        sb.append("Change back:" + "\n");
        sb.append(change + "\n" + "\n");
        sb.append("Time and date:" + "\n");
        sb.append(sale.getTimestamp() + "\n");
        sb.append("---------------------------" + "\n");
        System.out.println(sb.toString());
    }
}
