/*
JAVA CONSOLE GAME - CASINO
UGE 39 - GRUNDLÆGGENDE PROGRAMMERING
MARTIN - ELIN - CHRISTINE - ANDREAS
 */

import java.util.Random;
import java.util.Scanner;

public class Casino {
    public static void main(String[] args) {
        // Starting Balance is set
        int balance = 100;
        Scanner sc = new Scanner(System.in);
        // Story
        System.out.println("John sat in his car, staring at the crumpled $100 bill in his hand, knowing it was his last chance.");
        System.out.println("His debts had piled up, and with $10,000 hanging over his head, the casino felt like his only way out.");
        System.out.println("The lights inside were blinding, and the sound of slot machines echoed in his mind as he approached the poker table.");
        System.out.println("With a deep breath, he pushed the $100 forward, praying for the impossible.");
        System.out.println("\"This is it,\" he whispered to himself, \"win or lose, there’s no turning back now.\"");
        // To not flood the console
        System.out.println("Press Enter to continue...");
        sc.nextLine();
        System.out.println("Welcome to the Casino!");
        System.out.println(" _____   _____   _____   _____ ");
        System.out.println("|A    | |K    | |Q    | |J    |");
        System.out.println("|  ♠  | |  ♥  | |  ♦  | |  ♣  |");
        System.out.println("|     | |     | |     | |     |");
        System.out.println("|____V| |____K| |____Q| |____J|");
        System.out.println("  ____\n" +
                " /\\' .\\    _____\n" +
                "/: \\___\\  / .  /\\\n" +
                "\\' / . / /____/..\\\n" +
                " \\/___/  \\'  '\\  /\n" +
                "          \\'__'\\/");
        System.out.println("Try your luck and win big!");
        // To not flood the console
        System.out.println("Press Enter to continue...");
        sc.nextLine();
        //Game loop begins
        while(balance < 100000) {
            // Main game - Here the player chooses between the different games.
            if (balance > 0 && balance < 10000) {
                System.out.println("Please select from our list of games! \n" +
                        "1. Random Chance Game - Test your luck! \n" +
                        "2. Guess The Number - Guess the number between 1-100 \n" +
                        "3. HangMan - Guess the word, letter by letter!\n" +
                        "6. Check your current balance!");
                int choice = sc.nextInt();
                // Switch to choose which game - Uses methods to call each game.
                switch (choice) {
                    case 1:
                        balance = ChanceGame(balance);
                        break;
                    case 2:
                        balance = guessTheNumber(balance);
                        break;
                    case 3:
                        balance = hangMan(balance);
                        break;
                    case 6:
                        System.out.println("Your current balance is $" + balance);
                        System.out.println();
                        break;
                    default:
                        break;
                }
                // Ending if you ran out of money
            } else if (balance <= 0) {
                System.out.println();
                System.out.println("John ran out of money :(");
                System.out.println("John walked out of the casino with empty pockets and a heavier heart, realizing \n " +
                        "he had dug himself deeper into debt. As he drove away, he knew he \n" +
                        "would have to face the consequences of his gamble, feeling more lost than ever.");
                break;
                // Ending if you gained more than $10000
            } else {
                System.out.println();
                System.out.println("As the cards were dealt, John felt a surge of adrenaline. \n" +
                        "He played with skill and determination, each hand bringing him closer to victory. " +
                        "The final round arrived, and with one last bet, he revealed a royal flush. \n" +
                        "Cheers erupted around him, and the dealer pushed a stack of chips his way—$10,000! \n" +
                        "John couldn’t believe his luck. With tears of joy in his eyes, he left \n" +
                        "the casino, ready to pay off his debts and start anew. \n" +
                        "The burden that had weighed him down was finally lifted, and he felt a sense of hope for the future.\n" +
                        "\n" +
                        "You've Won!");
                break;
            }
        }
    }
    private static int ChanceGame(int balance) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧\n" +
                "Welcome to the Random Chance Game. \n" +
                "✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧\n" +
                " The goal of the game is to simply sit back and late fate take the wheel! \n " +
                "We will roll a number between 1-100 and depending on the outcome \n " +
                "You can win up to 3x your bet! 1-60 You Lose, 61-90 2x, 91-100 3x!!");
        // Asks for bet input
        System.out.println("Please enter your bet: ");
        int bet = sc.nextInt();
        // Incase the bet > balance
        if (bet > balance) {
            System.out.println("Your bet is greater than the current balance");
        } else {
            //Game Loop Starts - Balance being subtracted
            balance -= bet;
            System.out.println("You've bet $" + bet + " and your current balance is $" + balance);
            // Random number being chosen between 1-100
            int randomNumber = rand.nextInt(100);
            if (randomNumber < 60) {
                System.out.println("You Lost");
                System.out.println();
            } else if (randomNumber > 61 && randomNumber < 90) {
                System.out.println("You Won 2x your bet!");
                balance += bet * 2;
                System.out.println("Your new balance is $" + balance);
                System.out.println();
            } else if (randomNumber > 90) {
                System.out.println("You Won 3x your bet!");
                balance += bet * 3;
                System.out.println("Your new balance is $" + balance);
                System.out.println();
            }
        }
        return balance;
    }
    private static int guessTheNumber(int balance) {
            Scanner input = new Scanner(System.in);
            Random rand = new Random();
            int random = rand.nextInt(100) ; //Generates number between 1 and 100

            System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧\n" +
                    "Welcome to the Guess the number. \n" +
                    "✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧\n" +
                    " The goal of the game is to guess a randomly generated number between 1 and 100. \n " +
                    "You'll receive hints to guide your guesses.\n" +
                    " Your balance will decrease with each incorrect guess (by 20) ,\n" +
                    " but you can earn points (100) if you guess correctly.\n" +
                    "Type R when you are ready.");
            String ready = input.nextLine();

            //Game starts after r is typed in the console
            if (ready.equalsIgnoreCase("r")) ;
            while (!ready.equalsIgnoreCase("r")) {
                System.out.println("Invalid input. Please type 'R' when you are ready.");
                ready = input.nextLine();
            }
            //Ask the user for input (a number to compares with the randomly generated number)
            System.out.println("Guess the number between 1 and 100");

            // Random number gets checked with conditions and the give user a hint
            if (random % 2 == 0) {
                System.out.println("Hint: the number is even");
            } else {
                System.out.println("Hint: the number is odd");
            }
            if (random % 5 == 0) {
                System.out.println("A number is divisible by 5");
            } else {
                System.out.println("A number is NOT divisible by 5");
            }
            if (random % 3 == 0) {
                System.out.println("A number is divisible by 3");
            } else {
                System.out.println("A number is NOT divisible by 3");
            }
            // User input for the guessed number
            int guess = input.nextInt();

            //The guessed number is compared to the randomly generated number
            while (guess != random) {
                if (balance > 0) {
                    balance -= 20;
                    //Hint. The guessed number is compared with generated number (greater or smaller)
                    if (guess > random) {
                        System.out.println("Your number is too high");
                    } else
                        System.out.println("Your number is too low");
                    // Hint that shows to user how far number is from input to the random number
                    int difference = Math.abs(guess - random);
                    {
                        if (difference <= 10) {
                            System.out.println("Hint: You're within 10 numbers of the correct answer.");
                        } else if (difference > 10) {
                            System.out.println("Hint: You're far from the correct number (10  or more).");
                        }
                    }
                    System.out.println("Your balance is $" + balance); //Balance shows after each attempt

                    guess = input.nextInt(); //Next input for the next attempt
                } else
                    break;
            }
            //Balance increased by 100 after the guessed number is equal to the random
            if (guess == random) {
                balance += 100;
                System.out.println("Congratulations! You win and your balance is $" + balance);
            }

        return balance;
    }
    private static int hangMan(int balance) {
        int bet;
        int guessAmmount = 0;
        // Words for Hangman in array
        String[] hangmanWords = {"coffee", "potato"};

        // Choose random word by choosing a random Index from the array length of the array and assigning it to a String
        Random rand = new Random();
        String chosenWord = hangmanWords[rand.nextInt(hangmanWords.length)];

        // Stringbuilder called result, is initialized
        // This is where we will build up our answer depending on the guesses
        StringBuilder result = new StringBuilder();

        // Make the new string consist of underscore, equal to the length of the word
        for (int i = 1; i <= chosenWord.length(); i++) {
            result.append('_');
        }
        // Initialize scanner for user input
        Scanner sc = new Scanner(System.in);
        System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧\n" +
                "Welcome to Hangman!. \n" +
                "✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧\n" +
                " The goal of the game is to guess a random word! \n " +
                "You guess a letter, and if it matches somewhere in our word, \n" +
                " it shows it to you!\n" +
                " You have a maximum of 10 guesses, so choose wisely!\n");
        // Bet is made
        System.out.println("How much do you want to bet?");
        bet = sc.nextInt();
        // Check if bet is over current balance
        if (bet > balance) {
            System.out.println("Your bet is greater than the current balance");
            System.out.println("Please enter a valid bet: ");
            bet = sc.nextInt();
        }
        System.out.println("You've bet $" + bet + " and your current balance is $" + (balance-bet));
        System.out.println();
        // Create Boolean to mark if word has been guessed or not.
        boolean isCompleted = false;
        // Gameplay Loop starts.
        // While our boolean is false
        while (!isCompleted && guessAmmount < 10) {
            System.out.println("You currently have " + (10-guessAmmount) + " guesses");
            // Changes depending on what words has been guessed
            System.out.println("The word is currently looking like: " + result);
            // Prompts the user to make a guess
            System.out.println("Please make a guess :");
            // Assigns the first letter of the guess to a char called target
            char target = sc.next().charAt(0);
            guessAmmount++;
            //
            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == target) {
                    result.setCharAt(i, target);
                }
            }

            // When no more _ is in our result, we mark it complete to get out of the while loop
            if (result.indexOf("_") == -1){
                isCompleted = true;
            }
        }
        // If guess amount is under 10, you've won.
        if (guessAmmount < 10 && guessAmmount >= 0) {
            System.out.println("The word was " + chosenWord + "!");
            System.out.println("You've won 5x your bet!");
            balance = (balance-bet) + (bet * 5);
            System.out.println("Your balance is $" + balance);
            System.out.println();
        } else {
            System.out.println("The word was " + chosenWord + "!");
            System.out.println("You've lost, too bad..");
            balance = balance - bet;
            System.out.println();
        }
        return balance;
    }
}