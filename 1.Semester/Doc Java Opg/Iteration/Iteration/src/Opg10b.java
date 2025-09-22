public class Opg10b {
    public static void løsning(int x) {
        System.out.println("Opgave 10b:");
        x = -x;
        int a = 1;
        int b = 1;
        int c = b;

        for (int i = 3; i <= x; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        if ( x % 2 == 0 )
            b = -b;
        System.out.println( x + "! er " + b);
        System.out.println();
    }
}
