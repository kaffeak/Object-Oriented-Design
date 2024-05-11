package store.view;

import store.Utils.TotalRevenueObserver;

public class TotalRevenueView implements TotalRevenueObserver {
	private float totalRevenue = 0;
	public TotalRevenueView(){
	}

	/*
	 * Prints the total revenue to the terminal.
	 * 
	 * @param new running total from the ended sale.
	 */
	@Override
	public void printTotRev(float newSale) {
		totalRevenue += newSale;
		System.out.println("Total Revenue this far: " + totalRevenue);
	}
	
	
}
