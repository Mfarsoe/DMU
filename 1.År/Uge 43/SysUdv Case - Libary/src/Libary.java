import java.util.ArrayList;
import java.util.List;

public class Libary {
    private List<Book> books;

    public Libary() {
        books = new ArrayList<Book>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBook(Book book) {
        books.remove(book);
    }
    public List<Book> getBooks() {
        return books;
    }
}
