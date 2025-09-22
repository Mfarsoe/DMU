import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibrarySystem {
    private static final String BOOKS_FILE = "books.dat";
    private static final String MEMBERS_FILE = "members.dat";
    private static List<Book> books;
    private static List<Member> members;

    // Load books and members when the system starts
    static {
        try {
            books = loadBooks();
            members = loadMembers();
        } catch (Exception e) {
            books = new ArrayList<>();
            members = new ArrayList<>();
        }
    }

    // Save a list of books to file
    public static void saveBooks() throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(BOOKS_FILE);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(books);
        }
    }

    // Load a list of books from file
    public static List<Book> loadBooks() throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(BOOKS_FILE);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return (List<Book>) objectIn.readObject();
        }
    }

    // Save a list of members to file
    public static void saveMembers() throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(MEMBERS_FILE);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(members);
        }
    }
    // Add member to file
    public static void addMember(Member member) throws IOException {
        members.add(member);
        saveMembers();
        System.out.println("Member added: " + member);
    }

    // Load a list of members from file
    public static List<Member> loadMembers() throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(MEMBERS_FILE);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return (List<Member>) objectIn.readObject();
        }
    }

    // Add a book to the library collection (for librarians)
    public static void addBook(Book book) throws IOException {
        books.add(book);
        saveBooks();
        System.out.println("Book added: " + book);
    }

    // Reserve a book (for normal members)
    public static boolean reserveBook(String bookId, NormalMember member) throws IOException {
        Optional<Book> bookOpt = books.stream().filter(b -> b.getIsbn().equals(bookId) && !b.isReserved()).findFirst();
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setReserved(true);
            book.setReservedBy(member.getMemberId());
            saveBooks();
            System.out.println("Book reserved: " + book);
            return true;
        } else {
            System.out.println("Book is not available for reservation.");
            return false;
        }
    }

    // Lend a book to a member (only if it's reserved by them)
    public static boolean lendBook(String bookId, NormalMember member) throws IOException {
        Optional<Book> bookOpt = books.stream().filter(b -> b.getIsbn().equals(bookId) && b.isReservedBy(member.getMemberId()) && !b.isLent()).findFirst();
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setLent(true);
            saveBooks();
            System.out.println("Book lent: " + book);
            return true;
        } else {
            System.out.println("Book is not available for lending or is reserved by another member.");
            return false;
        }
    }
}
