public class Terning {
    public static String Øjne(int x){
        if (x < 1 || x > 6) {
            return "Invalid ";
        }
        switch (x) {
            case 1:
                return "Det er en ener";
            case 2:
                return "Det er en toer";
            case 3:
                return "Det er en treer";
            case 4:
                return "Det er en fire";
            case 5:
                return "Det er en femmer";
            default:
                return "Det er en sekser";
        }
    }
}
