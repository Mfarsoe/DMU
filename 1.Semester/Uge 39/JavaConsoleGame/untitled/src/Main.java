import java.util.*;

public class Main {
    public static void main(String[] args) {
        int bet, balance;
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
        // Bet is made
        System.out.println("How much do you want to bet?");
        bet = sc.nextInt();

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
        } else {
            System.out.println("The word was " + chosenWord + "!");
            System.out.println("You've lost, too bad..");
        }
    }
}
