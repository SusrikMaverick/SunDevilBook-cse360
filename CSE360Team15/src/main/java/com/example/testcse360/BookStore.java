package com.example.testcse360;

import java.util.ArrayList;
import java.util.List;

public class BookStore {
    private static BookStore instance;  // Singleton instance
    private List<Transaction> transactions = new ArrayList<>();  // Tracks transactions only

    // Private constructor to enforce singleton
    private BookStore() {}

    // Public method to get the single instance of BookStore
    public static BookStore getInstance() {
        if (instance == null) {
            instance = new BookStore();
        }
        return instance;
    }

    // Record a transaction
    public void recordTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Retrieve all transactions
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
