import java.util.List;
import java.util.stream.Collectors;

public class Admin extends Account {

	private String adminID;
	private String firstName;
	private String lastName;
	
	
	public Admin(String username, String email, String role) {
		super(username, email, role);
	}
	
	/* Method to filter transaction tableview by transactionId
	 * *****Uncomment this when transaction class is made*****
	 * public List<Transaction> filterTransactionsByTransactionID(String transactionID) {
	    return transactions.stream()
	                       .filter(t -> t.getTransactionID().equalsIgnoreCase(transactionID))
	                       .collect(Collectors.toList());
	}*/


	/* Method to filter transaction tableview by order status 
	 * *****Uncomment this when transaction class is made*****
	 * public List<Transaction> filterTransactionsByOrderStatus(String orderStatus) {
	    return transactions.stream()
	                       .filter(t -> t.orderStatus().equalsIgnoreCase(orderStatus))
	                       .collect(Collectors.toList());
	}*/
	
	/* Add methods for the editing of the transaction tableview 
	 * 		 private void editBookCategory()
	 * 		 private void editBookCondition()
	 *  	 private void editTransactionStatus()
	 */
	
	/* Method to filter inventory tableview by:
	 * 		(1) book category
	 * public List<Inventory> filterInventoryByCategory(String bookCategory) {
	    return inventory.stream()
	                       .filter(t -> t.getBookCategory().equalsIgnoreCase(bookCategory))
	                       .collect(Collectors.toList());
	 * 		(2) book conditions
	 * public List<Inventory> filterInventoryByCondition(String bookCondition) {
	    return inventory.stream()
	                       .filter(t -> t.getBookCondition().equalsIgnoreCase(bookCondition))
	                       .collect(Collectors.toList());
	 * 		(3) selling transaction’s status (completed, pending, or sold out) 
	 * public List<Inventory> filterInventoryByTransactionStatus(String transactionStatus) {
	    return inventory.stream()
	                       .filter(t -> t.getStatus().equalsIgnoreCase(transactionStatus))
	                       .collect(Collectors.toList());
	 * 		(4) book title
	 * public List<Inventory> filterInventoryByBookTitle(String bookTitle) {
	    return inventory.stream()
	                       .filter(t -> t.getBookTitle().equalsIgnoreCase(bookTitle))
	                       .collect(Collectors.toList());
	 * 		(5) seller’s name
	 * public List<Inventory> filterInventoryBySellerName(String sellerName) {
	    return inventory.stream()
	                       .filter(t -> t.getSellerName().equalsIgnoreCase(sellerName))
	                       .collect(Collectors.toList());
	 * 		(6) author
	 * public List<Inventory> filterInventoryByAuthor(String author) {
	    return inventory.stream()
	                       .filter(t -> t.getAuthor().equalsIgnoreCase(author))
	                       .collect(Collectors.toList());
	 * */
	
	private void decactivateUser(Account user) {
		super.deactivateAccount(user);
	}
	
	private void configureSystemSettings(String paymentMethod, int currency, int taxRate, int shippingOptions) {
		
	}
	
	private void resetToDefaultSettings() {
		
	}
}