public class BooleanCheck {
    private static int x = 5, y = 8, z = 3;

    public static void BooleanCheck() {
        //True
        System.out.println((x <= 5 && z != y));
        //True
        System.out.println((x == 5 || x == y && z == 3));
        //False - OBS evn those this is True, we are using int, so they both become 1 making it false
        System.out.println((x / y > z / x));
        //False
        System.out.println((!(x != y - z ) == false));
        //True
        System.out.println((2 * x != x || x == 0));
        //True
        System.out.println((! true || ! false));
    }
}
