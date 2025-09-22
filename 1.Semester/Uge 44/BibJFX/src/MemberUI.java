import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MemberUI {

    public static void showReserveBook() {
        Stage window = new Stage();
        window.setTitle("Reserve Book");

        Label bookIdLabel = new Label("Book ID:");
        TextField bookIdField = new TextField();

        Button reserveButton = new Button("Reserve Book");
        reserveButton.setOnAction(e -> {
            String bookId = bookIdField.getText();
            NormalMember member = new NormalMember("Bob", "M001");
            member.reserveBook(bookId);
            window.close();
        });

        VBox vbox = new VBox(10, bookIdLabel, bookIdField, reserveButton);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 150);
        window.setScene(scene);
        window.show();
    }

    public static void showLendBook() {
        Stage window = new Stage();
        window.setTitle("Lend Book");

        Label bookIdLabel = new Label("Book ID:");
        TextField bookIdField = new TextField();

        Button lendButton = new Button("Lend Book");
        lendButton.setOnAction(e -> {
            String bookId = bookIdField.getText();
            NormalMember member = new NormalMember("Bob", "M001");
            member.lendBook(bookId);
            window.close();
        });

        VBox vbox = new VBox(10, bookIdLabel, bookIdField, lendButton);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 150);
        window.setScene(scene);
        window.show();
    }
}
