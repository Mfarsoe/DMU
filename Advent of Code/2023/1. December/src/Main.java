import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    // Mapping of textual digits to numeric values
    private static final Map<String, String> textDigitMap = new HashMap<>();

    static {
        textDigitMap.put("one", "1");
        textDigitMap.put("two", "2");
        textDigitMap.put("three", "3");
        textDigitMap.put("four", "4");
        textDigitMap.put("five", "5");
        textDigitMap.put("six", "6");
        textDigitMap.put("seven", "7");
        textDigitMap.put("eight", "8");
        textDigitMap.put("nine", "9");
    }

    public static void main(String[] args) {
        // Path to the input file
        String filePath = "input.txt";

        int totalCalibration = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                int calibrationValue = extractCalibrationValue(line.toLowerCase());
                System.out.println("Line: " + line + " -> Calibration Value: " + calibrationValue);
                totalCalibration += calibrationValue;
            }

            System.out.println("Total Calibration Value: " + totalCalibration);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static int extractCalibrationValue(String line) {
        // Combine both numeric and textual digits
        Pattern digitPattern = Pattern.compile("\\d|one|two|three|four|five|six|seven|eight|nine");
        Matcher matcher = digitPattern.matcher(line);

        String firstDigit = null;
        String lastDigit = null;

        while (matcher.find()) {
            String match = matcher.group();
            if (textDigitMap.containsKey(match)) {
                match = textDigitMap.get(match); // Convert textual digit to numeric
            }

            if (firstDigit == null) {
                firstDigit = match; // First digit found
            }
            lastDigit = match; // Update last digit each time
        }

        if (firstDigit != null && lastDigit != null) {
            // Combine first and last digit to form a two-digit number
            return Integer.parseInt(firstDigit + lastDigit);
        }
        return 0; // If not enough digits are found, return 0
    }
}
