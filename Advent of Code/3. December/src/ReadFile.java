// ReadFile.java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private List<String> inputData;

    // Læs input-txt-filen og spyt en ArrayList ud...
    public static List<ArrayList<Integer>> readInputFile(String filePath) {
        try {
            return parse(Files.readAllLines(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Læs input og returner en liste af strings
    public static List<String> readInputFileString(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<ArrayList<Integer>> parse(List<String> inputData) {
        List<ArrayList<Integer>> outList = new ArrayList<>();
        for (String line : inputData) {
            String[] parts = line.split(" ");
            ArrayList<Integer> intList = new ArrayList<>();
            for (String part : parts) {
                intList.add(Integer.parseInt(part));
            }
            outList.add(intList);
        }
        return outList;

    }
}
