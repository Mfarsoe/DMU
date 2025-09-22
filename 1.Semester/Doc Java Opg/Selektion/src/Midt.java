public class Midt {
    public static String Compare(int x, int y, int z) {
        if (x > y && x < z || x > z && y > x) {
            return "X er Midt";
        } else if (x < y && z > y || y > z && y < x) {
            return "Y er Midt";
        } else if (x < z && y > z || y < z && z < x) {
            return "Z er Midt";
        }
        return "To er ens, så der er ingen midt";
    }
}
