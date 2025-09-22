import java.io.IOException;

public class Librarian extends Member {
    public Librarian(String name, String memberId) {
        super(name, memberId);
    }

    // Method to add a new book to the library system
    public void addBook(Book book) {
        try {
            LibrarySystem.addBook(book);
        } catch (IOException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }
    // Method for librarian to add a new member (NormalMember or Librarian)
    public void createMember(String name, String memberId, boolean isLibrarian) {
        Member newMember;
        if (isLibrarian) {
            newMember = new Librarian(name, memberId);
        } else {
            newMember = new NormalMember(name, memberId);
        }

        try {
            LibrarySystem.addMember(newMember);
        } catch (IOException e) {
            System.out.println("Error adding member: " + e.getMessage());
        }
    }
}