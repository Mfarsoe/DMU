public class UligeTal {
    static int sum;
    public static void UligeTal() {
        for (int i = 1; i <= 20; i += 2) {
            sum += i;
            System.out.println("Index: " + i);
            System.out.println("Summen: " + sum);
            System.out.println();
        }
    }
}
