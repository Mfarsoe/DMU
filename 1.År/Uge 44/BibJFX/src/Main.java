import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library System");

        // Librarian Section
        Button librarianAddBookButton = new Button("Add Book (Librarian)");
        librarianAddBookButton.setOnAction(e -> showLibrarianAddBook());

        Button librarianAddMemberButton = new Button("Add Member (Librarian)");
        librarianAddMemberButton.setOnAction(e -> showLibrarianAddMember());

        // Member Section
        Button memberReserveBookButton = new Button("Reserve Book (Member)");
        memberReserveBookButton.setOnAction(e -> showMemberReserveBook());

        Button memberLendBookButton = new Button("Lend Book (Member)");
        memberLendBookButton.setOnAction(e -> showMemberLendBook());

        VBox vbox = new VBox(10, librarianAddBookButton, librarianAddMemberButton, memberReserveBookButton, memberLendBookButton);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Open window for adding a book (Librarian action)
    private void showLibrarianAddBook() {
        LibrarianUI.showAddBook();
    }

    // Open window for adding a member (Librarian action)
    private void showLibrarianAddMember() {
        LibrarianUI.showAddMember();
    }

    // Open window for reserving a book (Member action)
    private void showMemberReserveBook() {
        MemberUI.showReserveBook();
    }

    // Open window for lending a book (Member action)
    private void showMemberLendBook() {
        MemberUI.showLendBook();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
