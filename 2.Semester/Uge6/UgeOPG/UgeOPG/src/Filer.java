import java.io.*;
import java.util.HashMap;
import java.util.Locale;
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
        for (char c = 'A'; c <= 'Z'; c++) {
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
            System.out.println(String.format("%c: %d (%.2f%%)", c, count, percentage));
        }
    }

    public static void removeChar(String filename){
        File inputFile = new File(filename);
        File outputFile = new File("cleaned_" + filename); // Ny fil til renset tekst

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String ClearedLine = line.replaceAll("[^a-zA-Z]",""); //regex der kun includere alle a-z i upper og lowercase.
                bw.write(ClearedLine);
                bw.newLine();
            }
            System.out.println("Fil " + outputFile + " blev skrevet.");
        } catch (IOException e) {
            System.out.println("Fejl : " + e);
        }
    }

}
