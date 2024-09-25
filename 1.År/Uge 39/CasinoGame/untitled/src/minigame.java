import java.util.Random;
import java.util.Scanner;

public class minigame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int random = rand.nextInt(100) ; //Generates number between 1 and 100
        int balanceNumber = 100; // HERE INPUT FROM MAIN CODE
        System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧\n" +
                "Welcome to the Guess the number. \n" +
                "✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧\n" +
                " The goal of the game is to guess a randomly generated number between 1 and 100. \n " +
                "You'll receive hints to guide your guesses.\n" +
                " Your balance will decrease with each incorrect guess (by 20) ,\n" +
                " but you can earn points (100) if you guess correctly.\n" +
                "Type R when you are ready.");
        String ready = input.nextLine();

        if (ready.equalsIgnoreCase("r")) ;
        while (!ready.equalsIgnoreCase("r")) {
            System.out.println("Invalid input. Please type 'R' when you are ready.");
            ready = input.nextLine();
        }

        System.out.println("Guess the number between 1 and 100");

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

        int guess = input.nextInt();

        while (guess != random) {

            balanceNumber -= 20;
            if (guess > random) {
                System.out.println("Your number is too high");
            } else
                System.out.println("Your number is too low");

            int difference = Math.abs(guess - random);
            {
                if (difference <= 10) {
                    System.out.println("Hint: You're within 10 numbers of the correct answer.");
                } else if (difference > 10) {
                    System.out.println("Hint: You're far from the correct number (10  or more).");
                }  System.out.println(random); // REMOVE AFTER!!
            }
            System.out.println("Your balance is " + balanceNumber + "kr");

            guess = input.nextInt();

                }

           if (guess == random) {
                balanceNumber += 100;
                System.out.println("Congratulations! You win and your balance is " + balanceNumber + " kr !");
            }
        }
    }


