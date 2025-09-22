public class TopBundFinder {
    public static void main(String[] args) {
        int[] t = {3, 5, 4, 1, 1, 7, 4, 9, 9, 2, 5};

        //Starter ved Index 1, da index 0 aldrig kan opfylde vores if statements,
        //da den ikke har omkringliggende på begge sider.
        //Samme gælder for length - 1
        for (int i = 1; i < t.length - 1; i++) {

            //Tjekker begge sider af tallet og hvis den opfylder betingelserne, printer den toppen
            if (t[i] > t[i - 1] && t[i] > t[i + 1]){
                System.out.println("Top:\tt[" + i + "]=" + t[i]);
            }
            //Her tjekkes efter bund og printer
            if (t[i] < t[i - 1] && t[i] < t[i + 1]) {
                System.out.println("Bund:\tt[" + i + "]=" + t[i]);
            }
        }
    }
}