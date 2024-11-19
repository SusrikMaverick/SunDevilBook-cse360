import java.util.Date;

/*
 * Inventory Class defines setter and getter methods to help the Admin class with 
 * viewing all book listings and add/edit/remove listings.
 * This class also allows the Admin to approve seller transactions/listings by setting Status to "Completed".
 * When a listing is sold out, it's status should be automatically updated to "Sold Out".
 * 
 * Note: Admin cannot edit seller's name, title, author, and the book's original price.
 */


public class Inventory {
	private Date transactionDate;
	private String sellerID;
	private String sellerFirstName;
	private String sellerLastName;
	private String status;
	
	// The following are related to Book details below
	private String bookTitle;
	private String author;
	private String category;
	private double buyingPrice;
	private int quantity;
	private String condition;
	
	// Get and Set Transaction Date
	public Date getTransactionDate() {
        return transactionDate;
    }
	
	public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

	// Get and Set Seller ID
	public String getSellerID() {
        return sellerID;
    }
	
	public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }
	
	// Get and Set Seller's First Name
	public String getSellerFirstName() {
        return sellerFirstName;
    }
	
	public void setSellerFirstName(String sellerFirstName) {
        this.sellerFirstName = sellerFirstName;
    }
	
	// Get and Set Seller's Last Name
	public String getSellerLastName() {
        return sellerLastName;
    }
	
	public void setSellerLastName(String sellerLastName) {
        this.sellerLastName = sellerLastName;
    }
	
	// Get and set Status
    public String getStatus() {
        return status;
    }
    
    public void getStatus(String status) {
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Get and Set Book Title
    public String getBookTitle() {
        return bookTitle;
    }
    
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    
    // Get and Set Author
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    // Get and Set Category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Get and Set Buying Price
    public double getBuyingPrice() {
        return buyingPrice;
    }
    
    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }
    
    // Get and Set Quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Get and Set Condition
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
