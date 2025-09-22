import java.util.*;


public class diceRoll {
    public int diceRoll(int balance) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Welcome to Diceroll!");
        System.out.println("Please enter your bet: ");
        int bet = sc.nextInt();
        if (bet > balance) {
            System.out.println("Your bet is greater than the current balance");
        }   else {
            balance = balance - bet;
            System.out.println("You've bet $" + " and your current balance is $" + balance);

            int randomNumber = rand.nextInt(100);
            if (randomNumber < 60) {
                System.out.println("You Lost");
            } else if (randomNumber > 61 && randomNumber < 90) {
                System.out.println("You Won 2x your bet!");
                balance = balance + (bet * 2);
            } else if (randomNumber > 90) {
                System.out.println("You Won 3x your bet!");
                balance = balance + (bet * 3);
            }
        }

        return balance;
    }
}
