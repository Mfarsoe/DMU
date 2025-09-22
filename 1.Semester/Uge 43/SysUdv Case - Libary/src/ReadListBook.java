import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadListBook {
    public static List<Book> readFromFile(String fileName) throws IOException {
        try (FileInputStream fileIn = new FileInputStream(fileName)) {
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            return (List<Book>) objectIn.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}