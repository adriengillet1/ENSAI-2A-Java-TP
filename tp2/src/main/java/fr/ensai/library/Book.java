package fr.ensai.library;

/**
 * Represents a book.
 */
public class Book extends Item{

    // Attributes
    private String isbn;
    private Author author;

    /**
     * Constructs a new Book object.
     */
    public Book(String isbn, String title, Author author, int year, int pageCount) {
        super(title, year, pageCount);
        this.author = author;
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book : " + getTitle() + ", written by " + author.toString();
    }

}
