import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Multiply {

    public static void main(String[] args) throws IOException {
        List<String> data = ReadFile.readInputFileString("input.txt");

        String finalData = "";
        for (String s : data) {
            finalData += s;
        }

        String pattern = "mul\\((\\d+),(\\d+)\\)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(finalData);

        int totalsum = 0;
        while (matcher.find()) {
            int num1 = Integer.parseInt(matcher.group(1));
            int num2 = Integer.parseInt(matcher.group(2));
            totalsum += num1 * num2;
        }
        System.out.println(totalsum);

    }
}
