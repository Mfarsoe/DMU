public class Opg20 {
    public static void løsning() {
        System.out.println("Opgave 20:");
        int PosNeg[]= { 4, 9, -2, -6, 2, 6, -9, 4, 9, -1, 1, 0, -3, -3, 2, 7 };
        for (int i = 0; i < PosNeg.length; i++) {
            if (PosNeg[i] < 0) {
                System.out.print(PosNeg[i] + " ");
            }
        }
        System.out.println();
        System.out.println();
    }
}
