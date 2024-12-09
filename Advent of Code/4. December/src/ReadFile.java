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

    public static char[][] readFileToCharGrid(String filePath) {
        try {

            List<String> lines = Files.readAllLines(Paths.get(filePath));

            // Determine the size of the 2D array
            int rows = lines.size();
            int cols = lines.get(0).length(); // Assuming all rows have the same length

            // Initialize the 2D char array
            char[][] grid = new char[rows][cols];

            // Fill the grid with characters
            for (int i = 0; i < rows; i++) {
                grid[i] = lines.get(i).toCharArray();
            }

            return grid; // Return the filled grid
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return null;
        }
    }

}
