public class Main {



    public static void main(String[] args) {
        int[] t = {3, 5, 4, 1, 1, 7, 4, 9, 9, 2, 5};

        for (int i = 0; i < t.length; i++) {
            if (t[i] > t[i + 1] && t[i] > t[i - 1]) {
                System.out.println("top: t[" + i + "]=" + t[i]);
            }
        }
    }
}
