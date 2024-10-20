public class Opg27 {
    public static void Løsning() {
        System.out.println("Opgave 27:");
        int PosNeg[]= { 4, 9, -2, -6, 2, 6, -9, 4, 9, -1, 1, 0, -3, -3, 2, 7 };
        int sum = 0;
        for (int i = 0; i < PosNeg.length; i++) {
            if (PosNeg[i] >= 0 && PosNeg[i] % 2 == 1) {
                sum += PosNeg[i];
            }
        }
        System.out.println("Sum: " + sum);
        System.out.println();
    }
}
