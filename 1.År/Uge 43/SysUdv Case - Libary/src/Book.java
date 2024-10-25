public class Book {
    private String bookName;
    private String bookAuthor;
    private String ISBN;
    public boolean isAvailable;


    public Book(String bookName, String bookAuthor, String ISBN) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(bookName + " is borrowed!");
        } else {
            System.out.println(bookName + " is already borrowed!");
        }
    }
    public String getTitle() {
        return bookName;
    }
}
