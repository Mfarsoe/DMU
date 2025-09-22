import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LibrarianUI {

    public static void showAddBook() {
        Stage window = new Stage();
        window.setTitle("Add Book");

        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField();

        Label authorLabel = new Label("Author:");
        TextField authorField = new TextField();

        Label idLabel = new Label("ID:");
        TextField idField = new TextField();

        Button addButton = new Button("Add Book");
        addButton.setOnAction(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            String id = idField.getText();
            Book book = new Book(title, author, id);
            new Librarian("Alice", "L001").addBook(book);
            window.close();
        });

        VBox vbox = new VBox(10, titleLabel, titleField, authorLabel, authorField, idLabel, idField, addButton);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 200);
        window.setScene(scene);
        window.show();
    }

    public static void showAddMember() {
        Stage window = new Stage();
        window.setTitle("Add Member");

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label idLabel = new Label("Member ID:");
        TextField idField = new TextField();

        Label typeLabel = new Label("Librarian (true/false):");
        TextField typeField = new TextField();

        Button addButton = new Button("Add Member");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String memberId = idField.getText();
            boolean isLibrarian = Boolean.parseBoolean(typeField.getText());
            new Librarian("Alice", "L001").createMember(name, memberId, isLibrarian);
            window.close();
        });

        VBox vbox = new VBox(10, nameLabel, nameField, idLabel, idField, typeLabel, typeField, addButton);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 200);
        window.setScene(scene);
        window.show();
    }
}
