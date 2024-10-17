public class Opg9 {
    public static void løsning(int x) {
        System.out.println("Opgave 9:");
        int a = 1;
        int b = 1;
        int c = b;

        for (int i = 3; i <= x; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println("Det " + x + "´te fibonacci-tal er " + c);
        System.out.println();
    }
}
