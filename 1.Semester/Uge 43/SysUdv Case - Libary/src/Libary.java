import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Libary {
    private List<Book> books;

    public Libary() {
        books = new ArrayList<Book>();
    }
    public void addBook(Book book) {
        books.add(book);
        WriteList.writeToFile("books.dat", books);
    }
    public void removeBook(Book book) {
        books.remove(book);
    }
    public List<Book> getBooks() throws IOException {
        return ReadListBook.readFromFile("books.dat");
    }
}
