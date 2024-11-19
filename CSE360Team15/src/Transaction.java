import java.util.Date;

/*
 * Transaction Class defines getter and setter methods to help the Admin class with viewing Transactions History.
 * This class keeps records of book purchases/sales.
 * Each Transaction is identified by a unique Transaction ID, and ties a specific book sold by 
 * a specific Seller and bought by a specific buyer.
 * This class is used by the Admin class to view transactions history.
 * 
 * Note: Admin CANNOT edit transactions in transactions history, but they can edit the Inventory.
 */

public class Transaction {
	
    private String bookTitle;	
    private double amount;	// this is the Total book price
    private int quantity;	// this is the number of books sold in a given transaction
    private String category;
    private Date purchaseDate;
    private String transactionID; // each Transaction has a unique ID
    private String buyerID;
    private String buyerFirstName;
    private String buyerLastName;
    private String condition;
    private String status; 	// Can be set as "Completed" or "Pending"

    // Temporary Constructor for now
    public Transaction(String bookTitle, double amount, int quantity, String category) {
        this.bookTitle = bookTitle;
        this.amount = amount;
        this.category = category;
    }

    // Get and Set Book Title
    public String getBookTitle() { return bookTitle; }
   
    public void setBookTitle(String newBookTitle) {
    	this.bookTitle = newBookTitle;
    }
    
    // Get and Set Amount
    public double getAmount() { return amount; }
    
    public void setAmount(double newAmount) { 
    	this.amount = newAmount;
    }
    
    // Get and Set Quantity
    public int getQuantity() { return quantity; }
    
    public void setQuantity(int newQuantity) {
    	this.quantity = newQuantity;
    }
    
    // Get and Set Category
    public String getCategory() { return category; }
    
    public void setCategory(String newCategory) { 
    	this.category = newCategory;
    }
    
    // Get and Set purchaseDate
    public Date purchaseDate() { return purchaseDate;}
    
    public void setPurchaseDate(Date newPurchaseDate) {  
    	this.purchaseDate = newPurchaseDate;
    }
    
    // Get and Set transactionID
    public String transactionID() { return transactionID;}
    
    public void setTransactionID(String newTransactionID) { 
    	this.transactionID = newTransactionID;
    }
    
    
    // Get and Set purchaseDate
    public String buyerID() { return buyerID;}
    
    public void setBuyerID(String newBuyerID) { 
    	this.buyerID = newBuyerID;    	
    }
    
    // Get and Set buyerFirstName
    public String buyerFirstName() { return buyerFirstName;}
    
    public void setBuyerFirstName(String newFirstName) {
    	this.buyerFirstName = newFirstName;
    }
    
    // Get and Set buyerLastName
    public String buyerLastName() { return buyerLastName;}
    
    public void setBuyerLastName(String newLastName) {
    	this.buyerLastName = newLastName;
    }
    
    // Get and Set Condition
    public String condition() { return condition;}
    
    public void setCondition(String newCondition) {
    	this.condition = newCondition;
    }
    
    // Get and Set Status
    public String status() { return status;}
    
    public void setStatus(String newStatus) {
    	this.status = newStatus;
    }
    
}    

