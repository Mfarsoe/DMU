import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem librarySystem = new LibrarySystem();

        while (true) {
            System.out.println("Welcome to the Library System");
            System.out.println("1. Librarian Menu");
            System.out.println("2. Member Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    librarianMenu(scanner, librarySystem);
                    break;
                case 2:
                    memberMenu(scanner, librarySystem);
                    break;
                case 3:
                    System.out.println("Exiting the library system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void librarianMenu(Scanner scanner, LibrarySystem librarySystem) {
        while (true) {
            System.out.println("\nLibrarian Menu");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. View All Books");
            System.out.println("4. Exit to Main Menu");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addBook(scanner, librarySystem);
                    break;
                case 2:
                    addMember(scanner, librarySystem);
                    break;
                case 3:
                    librarySystem.displayBooksWithAvailability(); // Show books and their availability
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void memberMenu(Scanner scanner, LibrarySystem librarySystem) throws IOException {
        while (true) {
            System.out.println("\nMember Menu");
            System.out.println("1. Reserve Book");
            System.out.println("2. Lend Book");
            System.out.println("3. Exit to Main Menu");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    reserveBook(scanner, librarySystem);
                    break;
                case 2:
                    lendBook(scanner, librarySystem);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook(Scanner scanner, LibrarySystem librarySystem) {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();

        Book book = new Book(title, author, id);
        try {
            librarySystem.addBook(book);
            System.out.println("Book added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    private static void addMember(Scanner scanner, LibrarySystem librarySystem) {
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Is the member a librarian? (true/false): ");
        boolean isLibrarian = Boolean.parseBoolean(scanner.nextLine());

        try {
            librarySystem.addMember(isLibrarian ? new Librarian(name, memberId) : new Member(name, memberId));
            System.out.println("Member added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding member: " + e.getMessage());
        }
    }

    private static void reserveBook(Scanner scanner, LibrarySystem librarySystem) throws IOException {
        System.out.print("Enter Book ID to Reserve: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Your Member ID: ");
        String memberId = scanner.nextLine();

        Member member = findMemberById(librarySystem, memberId);
        if (member != null) {
            librarySystem.reserveBook(bookId, member);
        } else {
            System.out.println("Member not found with ID: " + memberId);
        }
    }

    private static void lendBook(Scanner scanner, LibrarySystem librarySystem) throws IOException {
        System.out.print("Enter Book ID to Lend: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Your Member ID: ");
        String memberId = scanner.nextLine();

        Member member = findMemberById(librarySystem, memberId);
        if (member != null) {
            librarySystem.lendBook(bookId, member);
        } else {
            System.out.println("Member not found with ID: " + memberId);
        }
    }

    private static Member findMemberById(LibrarySystem librarySystem, String memberId) {
        for (Member member : librarySystem.getMembers()) {
            if (member.getID().equals(memberId)) {
                return member; // Return the matching member
            }
        }
        return null; // Return null if no matching member is found
    }
}
