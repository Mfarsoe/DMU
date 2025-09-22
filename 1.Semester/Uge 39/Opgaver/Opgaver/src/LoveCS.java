// ****************************************************************
// LoveCS.java
//
// Use a while loop to print many messages declaring your
// passion for computer science
// ****************************************************************
import java.util.Scanner;

public class LoveCS
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        final int LIMIT = 10;
        System.out.println("Input amount");
        int input = sc.nextInt();
        int count = 0;
        int sum = 0;
        while (count < input){
            System.out.println("I love Computer Science!!");
            count++;
        }
        for (int i = 1; i <= input; i++){
            sum = i + sum;
        }
        System.out.println("Printed this message " + count + " times.\n" +
                "The sum of the numbers from 1 to " + input + " is " + sum);
    }
}