import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Libary lib = new Libary();
        Librarian l1 = new Librarian("Dorthe", 62);
        Book b1 = new Book("The Old Man and the Sea", "Ernest Hemingway", "9780020519102");

        while(true){
            System.out.println("\nMenu:");
            System.out.println("1. Librarian");
            System.out.println("2. Member");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("\nWelcome. Please choose what you want to do:");
                    System.out.println("1. Add Book");
                    System.out.println("2. Remove Book");
                    System.out.println("3. See Books");
                    choice = sc.nextInt();

                    switch(choice){
                        case 1:
                            System.out.println("Enter title:");
                            String title = sc.next();
                            System.out.println("Enter author:");
                            String author = sc.next();
                            System.out.println("Enter ISBN:");
                            String isbn = sc.next();
                            lib.addBook(new Book(title, author, isbn));
                            break;
                        case 2:

                            break;
                        case 3:
                            try {
                                lib.getBooks();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                    }
                case 2:
                    
            }
        }
    }
}
