public class Interval {
    public static String print(int x){
        //Check if number is bigger than 0
        if (x >= 0) {
            //Switch to divide by 10 so we get our ranges
            switch (x / 10) {
                case 0:
                    return "[" + x + ":9]";
                case 1:
                    return "[" + x + ":19]";
                case 2:
                    return "[" + x + ":29]";
                case 3:
                    return "[" + x + ":39]";
                case 4:
                    return "[" + x + ":49]";
                case 5:
                    return "[" + x + ":59]";
                case 6:
                    return "[" + x + ":69]";
                case 7:
                    return "[" + x + ":79]";
                case 8:
                    return "[" + x + ":89]";
                case 9:
                    return "[" + x + ":99]";
                default:
                    //anything above 99 is invalid
                    return "Invalid Interval";
            }
        } else return "Invalid Interval";
    }
}
