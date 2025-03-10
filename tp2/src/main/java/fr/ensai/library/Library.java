package fr.ensai.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a library with books.
 */
public class Library {

    // Attributes
    private String name;
    private List<Item> items;
    private List<Loan> activeLoans;
    private List<Loan> completedLoans;

    /**
     * Constructs a new Library object.
     */
    public Library(String name, List<Item> items) {
        this.name = name;
        this.items = items;
        this.activeLoans = null;
        this.completedLoans = null;
    }

    public void addBook(Item item) {
        // int nb_books_before = this.books.size();
        this.items.add(item);
        // int nb_books_after = this.books.size();
        // if (nb_books_after == nb_books_before + 1) {
        // return true;
        // } else {
        // return false;
        // }
    }

    public void displayItems() {
        if (this.items.size() != 0) {
            System.out.println("List of items available in the library :");
            for (Item item : this.items) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Error : no book in the library.");
        }
    }

    /**
     * Loads books from a CSV file and adds them to the library.
     * 
     * @param filePath The path to the CSV file containing book data.
     * @throws IOException If there is an error reading the file, an
     *                     {@link IOException} will be thrown.
     */
    public void loadBooksFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        int authorAge = 39;
                        String authorNationality = "French";
                        author = new Author(authorName, authorAge, authorNationality);
                        authors.put(authorName, author);
                    }
                    Book book = new Book(isbn, title, author, year, pageCount);

                    this.addBook(book);
                }
            }
        } catch (

        IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public Loan findActiveLoanForItem(Item item) {
        Loan res = null;
        for (Loan loan: this.activeLoans){
            if (loan.getItemName() == item.getTitle()) {
                res = loan;
                break;
            }
        }
        return res;
    }

    public List<Book> getBooksByAuthor(Author author) {
        List<Book> list_book_by_author;
        for (Item item: this.items){
            if (item instanceof Book){
                if (item.getAuthor() == author) {
                    list_book_by_author.add(item);
                }
            }            
        }
        return list_book_by_author;
    }
}
