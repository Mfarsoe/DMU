public class KrydsOgBolle {
    static int krydsOgBolle[][] = { {1,2,1},
                                    {2,1,0},
                                    {0,0,2} };

    public static void PrintKrydsOgBolle() {
        for (int i = 0 ; i < krydsOgBolle.length ; i++) {
            for (int j = 0 ; j < krydsOgBolle[i].length ; j++) {
                if (krydsOgBolle[i][j] == 0) {
                    System.out.print(" ");
                } else if (krydsOgBolle[i][j] == 1) {
                    System.out.print("X");
                } else if (krydsOgBolle[i][j] == 2) {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }



}
