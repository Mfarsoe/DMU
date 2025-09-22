public class Opg26 {
    public static void Løsning() {
        System.out.println("Opgave 26:");
        int Tabel[] = { 5, 8, 1, 9, 3, 6, 2, 3, 9, 4, 7, 5, 7, 2, 0, 1, 0, 2 };
        int count = 0;
        for (int i = 0; i < Tabel.length; i++) {
            if (Tabel[i] == 7) {
                count++;
            }
        }
        System.out.println("Antallet af 7'ere er: " + count);
        System.out.println();
    }
}
