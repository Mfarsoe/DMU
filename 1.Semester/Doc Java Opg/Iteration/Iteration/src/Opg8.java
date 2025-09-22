public class Opg8 {
    public static void løsning() {
        System.out.println("Opgave 8:");
        int minimum = 3;
        int maximum = 16;
        int sum = 0;
        int count = 0;
        for (int i = minimum; i <= maximum; i++) {
            if (i % 2 == 0) {
                sum += i;
                count++;
            }
        }
        int gennemsnit = sum / count;
        System.out.println("For [" + minimum + ":" + maximum + "] er gennemsnittet " + gennemsnit);
        System.out.println();
    }
}
