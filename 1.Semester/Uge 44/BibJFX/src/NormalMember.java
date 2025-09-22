import java.io.IOException;

public class NormalMember extends Member {
    public NormalMember(String name, String memberId) {
        super(name, memberId);
    }

    // Method to reserve a book
    public void reserveBook(String bookId) {
        try {
            LibrarySystem.reserveBook(bookId, this);
        } catch (IOException e) {
            System.out.println("Error reserving book: " + e.getMessage());
        }
    }

    // Method to lend a book (if it's reserved by the member)
    public void lendBook(String bookId) {
        try {
            LibrarySystem.lendBook(bookId, this);
        } catch (IOException e) {
            System.out.println("Error lending book: " + e.getMessage());
        }
    }
}