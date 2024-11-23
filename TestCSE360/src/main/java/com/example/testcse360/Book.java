package com.example.testcse360;

public class Book {
    private int id; // Unique identifier for each book
    private String title;
    private String author;
    private String category;
    private String condition;
    private double originalPrice;
    private double sellingPrice;

    // Constructor with ID (used when fetching books from the database)
    public Book(int id, String title, String author, String category, String condition, double originalPrice, double sellingPrice) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.condition = condition;
        this.originalPrice = originalPrice;
        this.sellingPrice = sellingPrice;
    }

    // Constructor without ID (used when adding new books to the database)
    public Book(String title, String author, String category, String condition, double originalPrice, double sellingPrice) {
        this(-1, title, author, category, condition, originalPrice, sellingPrice); // Default ID to -1
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getCondition() {
        return condition;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }
}
