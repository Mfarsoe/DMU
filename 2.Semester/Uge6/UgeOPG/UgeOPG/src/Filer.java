import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Filer {
    public static void printSource(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void countChar(String filename){
        Map<Character, Integer> map = new HashMap<>();
        int totalLetters = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, 0);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.toUpperCase();
                for (char c: line.toCharArray()) {
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                        totalLetters++;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            int count = map.get(c);
            double percentage = totalLetters > 0 ? (count * 100.0 / totalLetters) : 0;
            System.out.println(String.format("%c: %d (%.2f%%)\n", c, count, percentage));
        }
    }

}
