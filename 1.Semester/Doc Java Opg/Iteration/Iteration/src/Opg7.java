public class Opg7 {
    public static void løsning() {
        System.out.println("Opgave 7:");
        int minimum = 2;
        int maximum = 16;
        int evencount = 0;
        int oddcount = 0;
        for (int i = minimum; i <= maximum; i++) {
            if (i % 2 == 0) {
                evencount++;
            } else
                oddcount++;
        }
        System.out.println("Der er " + oddcount + " og " + evencount + " lige tal i intervallet [" + minimum + ":" + maximum + "]");
        System.out.println();
    }
}
