public class Array {
    int Ulige[] = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29 };
    int Lige[] = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28 };
    int Tabel[] = { 5, 8, 1, 9, 3, 6, 2, 3, 9, 4, 7, 5, 7, 2, 0, 1, 0, 2 };
    int PosNeg[]= { 4, 9, -2, -6, 2, 6, -9, 4, 9, -1, 1, 0, -3, -3, 2, 7 };
    int T1[] = { 44, 71, 93, 24, 35, 21, 64 };
    int T2[] = { 32, 78, 12, 29, 21, 66, 92 };
    int T4[] = { 36, 20, 71, 45, 94, 36, 41 };
    int T5[] = { 53, 34, 31, 88, 85, 90, 11 };

    public static void PrintArrayBackwards() {
        int T3[] = { 25, 54, 62, 10, 99, 45, 23 };
        for (int i = T3.length - 1; i >= 0; i--) {
            System.out.println(T3[i]);
        }
    }

    public static void PrintAmmount(){
        int Tabel[] = { 5, 8, 1, 9, 3, 6, 2, 3, 9, 4, 7, 5, 7, 2, 0, 1, 0, 2 };
        int amount = 0;
        for (int i = 0; i < Tabel.length; i++) {
            if (Tabel[i] == 7) {
                amount++;
            }
        }
        System.out.println("7 var der " + amount + " antal gange");
    }

    public static void StørsteVærdi(){
        int T1[] = { 44, 71, 93, 24, 35, 21, 64 };
        int størt = 0;
        for (int i = 0; i < T1.length; i++) {
            if (T1[i] >= størt) {
                størt = T1[i];
            }
        }
        System.out.println(størt);
    }
}
