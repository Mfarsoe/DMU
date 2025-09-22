public class Opg23 {
    public static void Løsning() {
        System.out.println("Opgave 23:");
        int PosNeg[]= { 4, 9, -2, -6, 2, 6, -9, 4, 9, -1, 1, 0, -3, -3, 2, 7 };

        for (int i = 0; i < PosNeg.length; i++) {
            PosNeg[i] = -PosNeg[i];
        }
        for (int i = 0; i < 4; i++) {
            System.out.print(PosNeg[i] + " ");
        }
        System.out.println();
        for (int i = PosNeg.length - 4; i < PosNeg.length; i++) {
            System.out.print(PosNeg[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
