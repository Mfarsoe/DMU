import java.util.Scanner;

public class count {
    public static void main(String[] args) {
        //Exercise 1
        int LIMIT = 100; // setup
        int count = 1;
        while (count <= LIMIT) // condition
        { // body
            System.out.println(count); // -- perform task
            count = count + 1; // -- update condition
        }
        // Would move the amount counted by +1 cause here you print then count, whereas if you move it after, it first counts and then prints, making it so it still counts 100, but from 2 to 101, not 1 to 100



        //Exercise 2
        LIMIT = 16;
        count = 0;
        int sum = 0;
        int nextVal = 2;
        while (sum < LIMIT)
        {
            sum = sum + nextVal;
            nextVal = nextVal + 2;
            count = count + 1;
        }
        System.out.println("Had to add together " + (count) + " even numbers " +
                "to reach value " + LIMIT + ". Sum is " + sum);
        // sum = 2-6-12-20 nextVal = 2-4-6-8 count = 2-3-4-5. Chance count from = 1 to = 0.
        //Exercise 3
        count = 0;
        while (count <= 100) {
            System.out.println("I love computer science!!");
            count++;
        }
        //Exercise 4
        Scanner scan = new Scanner(System.in);
        sum = 0; //setup
        String keepGoing = "y";
        nextVal = 0;
        count = 0;
        while (keepGoing.equals("y") || keepGoing.equals("Y"))
        {
            System.out.print("Enter the next integer: "); //do work
            nextVal = scan.nextInt();
            sum = sum + nextVal;
            count++;
            System.out.println("Type y or Y to keep going"); //update condition
            keepGoing = scan.next();
        }
        System.out.println("The sum of your integers is " + sum);
        System.out.println("Number of integers is " + count);
        //Exercise 5
        count = 10;
        while (count > 0)
        {
            System.out.println(count);
            count = count - 1;
        }
    }
}
