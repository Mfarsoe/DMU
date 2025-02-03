import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DagEtDelEt {
    public static void main(String[] args) throws IOException {

        //Læser Input fra txt fil
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //laver to lists til opbevaring af de to lister
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();


        //Tilføjer hver enkelt linie til arraylisterne
        String linie;
        while ((linie = br.readLine()) != null) {
            String[] del = linie.trim().split("\\s+");  //.trim fjerner overflødige mellemrum.  .split("\\s+") referere til whitespace characters. + fortæller at der er flere charactere ergo flere mellemrum.
            leftList.add(Integer.parseInt(del[0])); //Tilføjer vestre del til leftList
            rightList.add(Integer.parseInt(del[1])); //Tilføjer højre del til rightList
        }
        //Lukker BufferedReader(ØVER MIG PÅ AT LUKKE ALLE CONNECTIONS)
        br.close();

        //Collections som gør det let at sortere fra mindst til størst. Tak chatGPT
        Collections.sort(leftList);
        Collections.sort(rightList);

        //Udregner totaldistance
        long totalDistance = 0;
        for (int i = 0; i < leftList.size(); i++) {
            totalDistance += Math.abs(leftList.get(i) - rightList.get(i));
        }
        System.out.println(totalDistance);
    }
}
