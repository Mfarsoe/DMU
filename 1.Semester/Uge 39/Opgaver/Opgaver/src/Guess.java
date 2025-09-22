// ************************************************************
// Guess.java
//
// Play a game where the user guesses a number from 1 to 10
//
// ************************************************************
import java.util.Scanner;
import java.util.Random;
public class Guess
{
    public static void main(String[] args)
    {
        int numToGuess; //Number the user tries to guess
        int guess; //The user's guess
        int guesslow = 0;
        int guesshigh = 0;
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
//randomly generate the number to guess
        numToGuess = generator.nextInt(10)+1;
//print message asking user to enter a guess
        System.out.println("Make your first guess: ");
        guess = scan.nextInt();
//read in guess
        while (guess != numToGuess) //keep going as long as the guess is wrong
        {
//print message saying guess is wrong
            if (guess > numToGuess) {
                System.out.println("Your guess is too high! Try again: ");
                guess = scan.nextInt();

                guesshigh++;
            } else {
                System.out.println("Your guess is too low! Try again: ");
                guess = scan.nextInt();

                guesslow++;
            }
//get another guess from the user
        }
//print message saying guess is right
        int guessamount = guesslow + guesshigh;
        System.out.println("Your guess is correct!! You used " + (guessamount + 1) + " guesses!");
        System.out.println(guesshigh + " guesses was too high! " + guesslow + " guesses was too low! And one guess was just right!");
    }
}