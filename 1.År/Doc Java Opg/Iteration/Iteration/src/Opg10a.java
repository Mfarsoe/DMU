public class Opg10a {
    public static void løsning(int x) {
        System.out.println("Opgave 10a:");
        int a = 1;
        int b = 1;
        int c;
        for (int i = 0; i >= x; i--) {
            c = a - b;
            a = b;
            b = c;
        }
        System.out.println(x + "! er " + b);
        System.out.println();
    }
}
