public class StørreEnd {
    public static String Compare(int x, int y, int z) {
        if (x > y && x > z) {
            return "X er større end Y og Z";
        } else if (x < y && z < y) {
            return "Y er større end X og Z";
        } else if (x < z && y < z) {
            return "Z er større end X og Y";
        }
            return "De er alle ens";
    }
}
