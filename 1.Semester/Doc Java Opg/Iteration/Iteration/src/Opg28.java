public class Opg28 {
    public static void Løsning() {
        System.out.println("Opgave 28:");
        int T1[] = { 44, 71, 93, 24, 35, 21, 64 };
        int størst = T1[0];
        for (int i = 0; i < T1.length; i++) {
            if (T1[i] > størst) {
                størst = T1[i];
            }
        }
        System.out.println("Største værdi er: " + størst);
        System.out.println();
    }
}
