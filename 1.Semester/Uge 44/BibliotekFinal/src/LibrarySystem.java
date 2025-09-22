import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibrarySystem {
    private static final String BOOKS_FILE = "books.txt";
    private static final String MEMBERS_FILE = "members.txt";
    private static List<Book> books;
    private static List<Member> members;


    static {
        try {
            books = loadBooks();
            members = loadMembers();
        } catch (Exception e) {
            books = new ArrayList<>();
            members = new ArrayList<>();
        }
    }
    //Member Håndtering
    public static void addMember(Member member) throws Exception {
        members.add(member);
        saveMembers();
        System.out.println("Member added: " + member);
    }

    public static List<Member> loadMembers() throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(MEMBERS_FILE);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)){
            return (List<Member>) objectIn.readObject();
        }
    }

    public static void saveMembers() throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(MEMBERS_FILE);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)){
            objectOut.writeObject(members);
        }
    }

    public static List<Member> getMembers() {
        return members;
    }

    //Book håndtering
    public static void addBook(Book book) throws Exception {
        books.add(book);
        saveBook();
        System.out.println("Book added: " + book);
    }

    public static List<Book> loadBooks() throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(BOOKS_FILE);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return (List<Book>) objectIn.readObject();
        }
    }
    public static void saveBook() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) {
                writer.write(book.toString());
                writer.newLine();
            }
        }
    }


    public static boolean reserveBook(String ISBN, Member member) throws IOException {
        for (Book book : books) {
            if (book.getIsbn().equals(ISBN) && book.isReservedBy(member.getID()) && !book.isLent()) {
                book.setReserved(true);
                book.setReservedBy(member.getID());
                saveBook();
                System.out.println("Book reserved: " + book);
                return true;
            }
        }
        System.out.println("Book not available for reservation.");
        return false;
    }

    public static boolean lendBook(String bookId, Member member) throws IOException {
        Optional<Book> bookOpt = books.stream().filter(b -> b.getIsbn().equals(bookId) && b.isReservedBy(member.getID()) && !b.isLent()).findFirst();
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setLent(true);
            saveBook();
            System.out.println("Book lent: " + book);
            return true;
        } else {
            System.out.println("Book is not available for lending or is reserved by another member.");
            return false;
        }
    }
    public static void returnBook(String bookId, Member member) throws IOException {
    }

    public List<Book> getBooks() {
        return books; // Returns the list of books
    }
    public void displayBooksWithAvailability() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            String availability = !book.isLent() ? "Available" : "Not Available";
            System.out.println("ID: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Status: " + availability);
        }
    }
}
