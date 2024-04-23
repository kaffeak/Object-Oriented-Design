package Integration;

import java.util.List;
import Model.Sale;
import Integration.ItemDTO;

public class ReceiptPrinter {
    private Sale sale;
    private List<ItemDTO> items;
        public ReceiptPrinter(){}

    public void printReciept(Sale sale){
        StringBuilder sb = new StringBuilder();

        items = sale.getItems();
        ItemDTO item;
        int i = items.size();
        while (i-- > 0){
            item = items.get(i);
            sb.append(item.getName() + item.getPrice() + item.getVAT() + "\n");
            i++;
        }
        sb.append(sale.getRunningTotal() + "\n");
        sb.append(sale.getTimestamp() + "\n");
        System.out.println(sb.toString());
    }
}
