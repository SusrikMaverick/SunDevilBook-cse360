
/*
 * Statistics Class contains overall book sale statistics to help the Admin class with displaying
 * the bookstore's statistics. 
 * This class defines getter and setter methods to assist the Admin class.
 */

public class Statistics {

	private int booksSold;		// This means books sold in total from last month
	private int totalInventory;		// This means total books currently in stock for selling.
	private double salesTotal;		// This means total money earned platform-wide from last month.
	private int totalPendingPurchases;	// This means total purchases that are pending
	private int totalAwaitingApproval;  // This means total selling transactions that are waiting to be approved by Admin.
	
	
	// Get and Set for booksSold
	public int getBooksSold() {
        return booksSold;
    }
	
	public void setBooksSold(int booksSold) {
        this.booksSold = booksSold;
    }

    // Get and Set for totalInventory
    public int getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(int totalInventory) {
        this.totalInventory = totalInventory;
    }

    // Get and set for salesTotal
    public double getSalesTotal() {
        return salesTotal;
    }

    public void setSalesTotal(double salesTotal) {
        this.salesTotal = salesTotal;
    }

    // Get and Set for totalPendingPurchases
    public int getTotalPendingPurchases() {
        return totalPendingPurchases;
    }

    public void setTotalPendingPurchases(int totalPendingPurchases) {
        this.totalPendingPurchases = totalPendingPurchases;
    }

    // Get and Set for totalAwaitingApproval
    public int getTotalAwaitingApproval() {
        return totalAwaitingApproval;
    }

    public void setTotalAwaitingApproval(int totalAwaitingApproval) {
        this.totalAwaitingApproval = totalAwaitingApproval;
    }
}
