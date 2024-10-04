public class ForskelTi {
    public static String P (int x, int y) {
        int compare;
        compare = x - y;
        if (compare >= 10 || compare <= -10){
            return "Forskellen er større end 10";
        }
        return "Forskellen er mindre end 10";
    }
}
