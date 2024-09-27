import java.util.Scanner;

public class Factorials {
    public static void main(String[] args) {
        int input, sum = 1, factor = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        input = sc.nextInt();
        while (input < 0) {
            System.out.print("Enter a positive number : ");
            input = sc.nextInt();
        }
        while (factor < input) {
            factor++;
            sum = factor * sum;
        }
        System.out.println("Factorial of " + input + "! is " + sum);;
    }
}
