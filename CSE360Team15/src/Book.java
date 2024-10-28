public class Book {
    private String title;
    private String author;
    private String category;
    private String condition;
    private double originalPrice;
    private double sellingPrice;

    public Book(String title, String author, String category, String condition, double originalPrice, double sellingPrice) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.condition = condition;
        this.originalPrice = originalPrice;
        this.sellingPrice = sellingPrice;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getCondition() { return condition; }
    public double getSellingPrice() { return sellingPrice; }
}
