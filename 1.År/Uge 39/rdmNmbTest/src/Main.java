import java.util.*;


public class Main {
    public static void main(String[] args) {
        int balance = 100;
        int choice;
        Scanner sc = new Scanner(System.in);

        while (balance < 10000) {
            if (balance > 0) {
            System.out.println("Select game:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    balance = DiceRoll(balance);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Your current balance is $" + balance);
                    break;
            }
            } else if (balance == 0) {
                System.out.println("You've run out of money :(");
                System.out.println("The loan sharks beat you up :(");
                break;
            }
        }
    }

    private static int DiceRoll(int balance) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Welcome to Diceroll!");
        System.out.println("Please enter your bet: ");
        int bet = sc.nextInt();
        if (bet > balance) {
            System.out.println("Your bet is greater than the current balance");
        }   else {
            balance = balance - bet;
            System.out.println("You've bet $" + bet + " and your current balance is $" + balance);

            int randomNumber = rand.nextInt(100);
            if (randomNumber < 60) {
                System.out.println("You Lost");
            } else if (randomNumber > 61 && randomNumber < 90) {
                System.out.println("You Won 2x your bet!");
                balance = balance + (bet * 2);
                System.out.println("Your new balance is $" + balance);
            } else if (randomNumber > 90) {
                System.out.println("You Won 3x your bet!");
                balance = balance + (bet * 3);
                System.out.println("Your new balance is $" + balance);
            }
        }

        return balance;
    }

}