import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DagEtDelTo {
    public static void main(String[] args) throws IOException {
        //Samme som del 1
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            leftList.add(Integer.parseInt(parts[0]));
            rightList.add(Integer.parseInt(parts[1]));
        }
        br.close();

        //Går igennem rightlist og finder antallet af gange hver enkelt talk er tilstede.
        //Tilføjer til hashmappet  antal gange det gælende tal opstår.
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : rightList) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        //for hvert nummer i leftlist, finder vi nummeret i rightlist, så ganger vi nummeret med antal gange nummeret er der.
        long totalScore = 0;
        for (int num : leftList) {
            int frequency = frequencyMap.getOrDefault(num, 0); // henter antal gange nummeret forekommer.
            totalScore += (long) num * frequency; // tilføjer til totalscore
        }


        System.out.println(totalScore);
    }
}