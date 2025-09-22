public class Opg19 {
    public static void løsning(){
        System.out.println("Opgave 19:");
        int sum = 0;
        int PosNeg[]= { 4, 9, -2, -6, 2, 6, -9, 4, 9, -1, 1, 0, -3, -3, 2, 7 };
        for (int i = 0; i < PosNeg.length; i++) {
            sum += PosNeg[i];
        }
        System.out.println(sum);
        System.out.println();
    }
}
