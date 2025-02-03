import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SafeNumberDelEt {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        List<List<Integer>> listOfNum = new ArrayList<>();
        Integer SafeNumber = 0;

        String line;
        while((line = br.readLine()) != null && !line.isEmpty()) {
            String[] numbers = line.split(" ");
            List<Integer> linie = new ArrayList<>();
            for(String number : numbers) {
                linie.add(Integer.parseInt(number));
            }
            listOfNum.add(linie);
        }
        br.close();

        //Hvert nummer i listen, tilføjer vi til counteren
        for (List<Integer> num : listOfNum) {
            if (isValid(num)) {
                System.out.println(num);
                SafeNumber++;
            }
        }
        System.out.println(SafeNumber);
    }

    public static boolean isValid(List<Integer> numbers) {
        boolean isAscending = true;

        //Finder retning
        if (numbers.size() > 1) {
            isAscending = numbers.get(1) > numbers.get(0);
        }

        for (int i = 1; i < numbers.size(); i++) {
            int current = numbers.get(i);
            int previous = numbers.get(i - 1);


            if (isAscending) {
               //Hvis stigende
                if (current <= previous || current - previous > 3) {
                    return false;
                }
            } else {
                //Hvis faldende
                if (current >= previous || previous - current > 3) {
                    return false;
                }
            }
        }
        return true;
    }
}
