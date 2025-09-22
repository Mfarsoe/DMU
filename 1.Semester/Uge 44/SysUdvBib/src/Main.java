public class Main {
    public static void main(String[] args) {
        // Initialize a librarian
        Librarian librarian = new Librarian("Alice", "L001");

        // Librarian adds a book
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "B001");
        librarian.addBook(book1);

        // Librarian creates a normal member
        librarian.createMember("Bob", "M001", false);

        // Librarian creates another librarian
        librarian.createMember("Charlie", "L002", true);

        // Test with the normal member Bob
        NormalMember member = new NormalMember("Bob", "M001");

        // Member reserves the book
        member.reserveBook("B001");

        // Member lends the book
        member.lendBook("B001");
    }
}
