
public class Member {
    private String name;
    private int memberID;


    public Member(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
    }

    public void reserveBook(Book book) {
        if (!book.isAvailable) {
            System.out.println(name + " reserved the book: " + book.getTitle());
        }
    }

    public void borrowBook(Book book) {
        book.borrowBook();
    }

}
