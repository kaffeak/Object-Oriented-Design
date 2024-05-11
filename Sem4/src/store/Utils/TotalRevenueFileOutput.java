package store.Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TotalRevenueFileOutput implements TotalRevenueObserver {
	private static final String fileSrc = "store/view/totalRevenue.txt";
	private PrintWriter pw;
	private float totalRevenue = 0;

	public TotalRevenueFileOutput(){
			try {
				pw = new PrintWriter(new FileWriter(fileSrc), true);
			}catch (IOException ex) {
				System.out.println("File totalRevenue could not be initiated");
				ex.printStackTrace();
				System.exit(1);
			}
	}

	/*
	 * Prints the total revenue to a file.
	 * 
	 * @param new running total from the ended sale.
	 */
	@Override
	public void printTotRev(double newSale) {
		totalRevenue += newSale;
		StringBuilder sb = new StringBuilder();
		sb.append("Total Revenue this far: " + totalRevenue);
		pw.println(sb);
	}
		
}
