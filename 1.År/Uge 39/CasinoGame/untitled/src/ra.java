import java.util.Scanner;
import java.util.Random;

public class ra {
    public static void main(String[] args) {
        //Welcome
        System.out.println("Welcome to Blackjack!");
        System.out.println("Money is doubled if you win!");

        //Player puts in bet
        Scanner sc = new Scanner(System.in);
        System.out.println("Please put in your bet ");
        int bet;
        bet = sc.nextInt();
        System.out.println("You bet " + bet + "$ " + "good luck!");

        //Randomizer (0-9 + 2) + ace 1 or 11?
        Random random = new Random();
        int playerCards = random.nextInt(10) + 2 + random.nextInt(10) + 2;
        int dealerCards = random.nextInt(10) + 2 + random.nextInt(10) + 2;


        //Player and Dealer draw their first two cards
        System.out.println("... \n\033[3mYou draw two cards - you feel lucky\033[0m");
        System.out.println("You have: " + playerCards + " - The Dealer has: " + dealerCards);


        //Hit or stand - player's turn
        while (true) {
            System.out.println("Will you 'hit' or 'stand'?");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("hit")) {
                int addCard = random.nextInt(10) + 2;
                System.out.println("You draw another card" + "\n...");
                System.out.println("It's a " + addCard);
                System.out.println("Your total is now: " + playerCards);

                if (playerCards > 21) {
                    System.out.println("You went over 21! You lose :(");
                    return;

                }
                else if (choice.equalsIgnoreCase("stand"))  {
                    break;
                }
                else {
                    System.out.println("Please choose 'hit' or 'stand'.");
                }

            }

        }


        //Dealer hit until 17 or higher
        System.out.println("It is now the dealer's turn");
        System.out.println("The dealer has " + dealerCards);

        while (dealerCards < 17) {
            int addCard = random.nextInt(10) + 2;
            System.out.println("The dealer draws a " + addCard);
            dealerCards += addCard;
            System.out.println("The dealer now has " + dealerCards);
        }

        //Who won?
        if (dealerCards > 21) {
            System.out.println("Dealer went over 21! You win :)");
        }
        else if (dealerCards > playerCards) {
            System.out.println("Dealer has " + dealerCards + "You have " +
                    playerCards + "You lose :(");
        }
        else if (dealerCards < playerCards) {
            System.out.println("Dealer has " + dealerCards + "You have " +
                    playerCards + "You win :)");
        }
        else {
            System.out.println("Dealer has " + dealerCards + "You have " +
                    playerCards + "It's a Tie!");
        }

        sc.close();

    }
}
