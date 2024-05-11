package store.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import store.integration.ItemDTO;
import store.Utils.TotalRevenueObserver;


/**
 * Represents the ongoing sale.
 */
public class Sale {
    private Timestamp timestamp;
    private double runningTotal;
    private double totalVAT;
    private ArrayList<ItemDTO> items;
	private List<TotalRevenueObserver> saleObservers = new ArrayList<>();

    /**
     * Creates a new instance of Sale.
     * 
     */
    public Sale(){
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.runningTotal = 0;
        this.totalVAT = 0;
        this.items = new ArrayList<ItemDTO>();
    }

    /**
     * Adds an {@link ItemDTO} to the sale object and increases the 
     * running total of the sale. It returns an {@link AddToSaleInfo} 
     * instance with the current running total and the added {@link ItemDTO}. 
     * 
     * @param item The <code>ItemDTO</code> to be added to the sale.
     * @param quantity The amount of items that should be added to sale.
     * @return The <code>AddToSaleInfo</code> containing information about 
     *         the last added item and the running total for the sale.
     */
    public AddToSaleInfo addToSale(ItemDTO item, int quantity){
        while (quantity-- > 0){
            this.items.add(item);
            this.runningTotal += item.getPrice() * ((item.getVAT()/100) + 1);
            this.totalVAT +=  item.getPrice() * item.getVAT()/100;
        }
        return getAddToSaleInfo();
    }
    private AddToSaleInfo getAddToSaleInfo(){
        return new AddToSaleInfo(this.items.get(this.items.size()-1), this.runningTotal, this.totalVAT);
    }

    /**
     * Returns the list of {@link ItemDTO} in sale.
     * 
     * @return The list of <code>ItemDTO</code> in sale.
     */
    public ArrayList<ItemDTO> getItems() {
        return this.items;
    }

    /**
     * Returns the timestamp from when the sale started.
     * 
     * @return The timestamp from when the sale started.
     */
    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    /**
     * Returns the running total for the sale.
     * 
     * @return The running total for the sale.
     */
    public double getRunningTotal() {
        return runningTotal;
    }

	/*
	 * Ends the sale and returns the running total for the sale.
	 * 
	 * @return The running total for the sale
	 */
	public double endSale(){
		notifyObservers();
		return getRunningTotal();
	}

	private void notifyObservers(){
		for (TotalRevenueObserver obs : saleObservers) {
			obs.printTotRev(runningTotal);
		}
	}

    /**
     * Returns the total VAT for the sale.
     * 
     * @return The total VAT for the sale.
     */
    public double getTotalVAT(){
        return this.totalVAT;
    }

    /**
     * Sets the value for running total
     * 
     */
    public void setRunningTotal(double newRunningTotal) {
        this.runningTotal = newRunningTotal;
    }

	/*
	 * Adds a list of observers to the sale.
	 * 
	 * @param The list of observers that should be added to the sale.
	 */
	public void addObservers(List<TotalRevenueObserver> observers){
		saleObservers.addAll(observers);
	}
}
