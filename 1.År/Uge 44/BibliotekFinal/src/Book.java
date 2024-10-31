import java.io.Serializable;
import java.util.Objects;


public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private String isbn;
    private boolean isReserved;
    private boolean isLent;
    private String reservedBy;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isReserved = false;
        this.isLent = false;
        this.reservedBy = null;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isReserved() { return isReserved; }
    public boolean isLent() { return isLent; }
    public String getReservedBy() { return reservedBy; }

    public void setReserved(boolean reserved) { this.isReserved = reserved; }
    public void setLent(boolean lent) { this.isLent = lent; }
    public void setReservedBy(String reservedBy) { this.reservedBy = reservedBy; }

    public boolean isReservedBy(String ID) {
        return this.reservedBy != null && this.reservedBy.equals(ID);
    }

    public boolean equals(Book other) {
        if (this== other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Book book = (Book) other;
        return Objects.equals(isbn, book.isbn);
    }

    public int HashCode() {
        return Objects.hash(isbn);
    }
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", isReserved=" + isReserved +
                ", isLent=" + isLent +
                ", reservedBy='" + reservedBy + '\'' +
                '}';
    }

}


