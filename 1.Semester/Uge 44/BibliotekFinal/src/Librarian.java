public class Librarian extends Member{


    public Librarian(String name, String ID, String password){
        super(name,ID,password);
    }

    public void addBook(Book book) {
        try {
            LibrarySystem.addBook(book);
        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    public void createMember(String name, String ID, String password, boolean isLibrarian){
        Member newMember;
        if(isLibrarian){
            newMember = new Librarian(name, ID,password);
        } else {
            newMember = new Member(ID, name, password);
        }
        try {
            LibrarySystem.addMember(newMember);
        } catch (Exception e) {
            System.out.println("Error adding member: " + e.getMessage());
        }
    }
}
