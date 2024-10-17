public class Opg4 {
    public static void løsning() {
        System.out.println("Opgave 4:");
       int n = 5;
       int f = 1;
       for (int tal = n; tal > 1; tal--) {
           f *= tal;
       }
       System.out.println(f);
       System.out.println();
    }
}
