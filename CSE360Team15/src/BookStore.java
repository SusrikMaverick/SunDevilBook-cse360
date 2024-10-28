import java.util.ArrayList;
import java.util.List;

public class BookStore {
    private static BookStore instance;  // Singleton instance
    private List<Book> booksForSale = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    // Private constructor to enforce singleton
    private BookStore() {
        // Pre-load some books
        addBook(new Book("Physics for Beginners", "John Doe", "Natural Science", "Used Like New", 50.00, 40.00));
        addBook(new Book("Java Programming", "Jane Smith", "Computer Science", "Moderately Used", 60.00, 30.00));
        addBook(new Book("Calculus 101", "Albert Newton", "Math", "Heavily Used", 40.00, 12.00));
        addBook(new Book("Shakespeare's Works", "William Shakespeare", "English", "Used Like New", 30.00, 24.00));
        addBook(new Book("Sci-Fi Novels", "Isaac Asimov", "Other", "Moderately Used", 25.00, 12.50));	
    }

    // Public method to get the single instance of BookStore
    public static BookStore getInstance() {
        if (instance == null) {
            instance = new BookStore();
        }
        return instance;
    }

    public void addBook(Book book) {
        booksForSale.add(book);
    }

    public List<Book> getBooksByCategory(String category) {
        List<Book> result = new ArrayList<>();
        for (Book book : booksForSale) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }
        return result;
    }

    public void recordTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
