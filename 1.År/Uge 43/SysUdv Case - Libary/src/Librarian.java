public class Librarian extends Member{

    public Librarian(String name, int memberID){
        super(name, memberID);
    }
    public void addBook(Book book, Libary libary){
        libary.addBook(book);
        System.out.println("Book added to libary: " + book.getTitle());
    }

    public void removeBook(Book book, Libary libary){
        libary.removeBook(book);
        System.out.println("Book removed from libary: " + book.getTitle());
    }
}
