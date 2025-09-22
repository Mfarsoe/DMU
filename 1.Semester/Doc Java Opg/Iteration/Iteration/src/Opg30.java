public class Opg30 {
    public static int PosNeg[]= { 4, 9, -2, -6, 2, 6, -9, 4, 9, -1, 1, 0, -3, -3, 2, 7 };

    public static void Løsning1() {
        System.out.println("Løsning 30.1:");
        int index = 0;
        do {
            if (PosNeg[index] < 0) {
                System.out.println(PosNeg[index]);
                break;
            }
            index++;
        } while (index < PosNeg.length);
        System.out.println();
    }
    public static void Løsning2() {
        System.out.println("Løsning 30.2:");
        for (int i = 0; i < PosNeg.length; i++) {
            if (PosNeg[i] < 0) {
                System.out.println(PosNeg[i]);
                break;
            }
        }
        System.out.println();
    }

    public static void Løsning3() {
        System.out.println("Løsning 30.3:");
        int index = 0;
        while (index < PosNeg.length) {
            if (PosNeg[index] < 0) {
                System.out.println(PosNeg[index]);
                break;
            }
            index++;
        }
        System.out.println();
    }
}

