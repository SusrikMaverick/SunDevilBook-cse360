public class Transaction {
    private String bookTitle;
    private double amount;
    private String category;

    public Transaction(String bookTitle, double amount, String category) {
        this.bookTitle = bookTitle;
        this.amount = amount;
        this.category = category;
    }

    // Getters and setters
    public String getBookTitle() { return bookTitle; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
}