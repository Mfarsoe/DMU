import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //System.out.println(sumDigits(-12345));
        //System.out.println(randomNum(4100 ));
        //Filer.printSource("src/Filer.java");
        Filer.countChar("input.txt");
    }

    public static int[] zeroFront(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if(num == 0) {
                result[index++] = 0;
            }
        }
        for (int num : nums) {
            if (num != 0) {
                result[index++] = num;
            }
        }
        return result;
    }

    public static int[] evenOdd(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if(num % 2 == 0) {
                result[index++] = num;
            }
        }
        for (int num : nums) {
            if (num % 2 != 0) {
                result[index++] = num;
            }
        }
        return result;
    }
    public static int sumDigits(int n) {
        if (n < 0) {
            n = -n;
        }
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumDigits(n / 10);
    }


    public static int randomNum(int n) {
        HashSet<Integer> temp = new HashSet();
        int newNum = n;

        while (!temp.contains(newNum)) {
            temp.add(newNum);
            int num = (int) Math.pow(newNum,2); //n til power af 2
            String s = String.format("%08d",num); //Tilføjer 0 foran hvis længde ikke er 8
            newNum = (Integer.parseInt(s) / 100) % 10000; //finder midt numrene.
        }

        return temp.size();
    }

}
