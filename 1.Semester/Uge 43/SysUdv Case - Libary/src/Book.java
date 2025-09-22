import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String bookName;
    private String bookAuthor;
    private String ISBN;
    public boolean isAvailable;


    public Book(String bookName, String bookAuthor, String ISBN) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }


    public boolean equals(Book b) {
        if (this == b) return true;
        if (b == null || getClass() != b.getClass()) return false;
        Book book = (Book) b;
        return Objects.equals(bookName, book.bookName) && Objects.equals(bookAuthor, book.bookAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, bookAuthor, ISBN, isAvailable);
    }


    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(bookName + " is borrowed!");
        } else {
            System.out.println(bookName + " is already borrowed!");
        }
    }
    public String getTitle() {
        return bookName;
    }
}
