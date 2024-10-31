import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WriteList {
    public static void writeToFile(String fileName, List list) {
        try (FileOutputStream fileOutput = new FileOutputStream(fileName)) {
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(list);
            System.out.println("Success writing to " + fileName);
            objectOutput.close();
        } catch (IOException e) {
            System.out.println("An error has occured while writing the list to the file");
            e.printStackTrace();
        } ;
    }
    public static void removeFromFile(String fileName, List list) throws IOException {
        List<Book> books = ReadListBook.readFromFile(fileName);

        boolean removed = books.remove(list);
        if (removed) {
            System.out.println("Book had been removed from the list");
        } else {
            System.out.println("Book not in list");
        }
        writeToFile(fileName, books);
    }
}

