import java.util.Scanner; //scanner for input from player for bet
import java.util.Random; //Random generator for dice-roll

//The casino game Craps
public class CrapsGame {
    int dice1, dice2;
    int rollSum;
    int betAmount;
    int balance;
    boolean playing;
    Scanner bet = new Scanner(System.in);
    Random random = new Random();

//Set balance from rest of casino game
    public CrapsGame(int startingBalance) {
    this.balance = startingBalance;
    }

//Make method to roll 1 die from 1-6
    public int rollDice() {
    return random.nextInt(6) +1;
    }

//Method for handling first roll of both dice
    public String checkFirstRoll(int rollSum){
        if (rollSum == 7 || rollSum == 11){ //If the total is 7 or 11...
            return "win"; //player wins on first roll
        }
        else if (rollSum == 2 || rollSum == 3 || rollSum == 12) {//If the total is 2,3 or 12...
            return "lose"; //player loses on first roll
        }
        else {
            return "point"; //Other number (4,5,6,8,9,10) is set as the Point
        }
    }

//Method placing bet - doesnt need
    public int placeBet(){
        do {
            System.out.println("Current balance: " + balance);
            System.out.println("Place your bet: ");
            betAmount = bet.nextInt();

            if (betAmount > balance) {
                System.out.println("You can't bet more than you have!");
            }
        }
        while (betAmount > balance);
        return betAmount;
    }

//Method to handle the "point", all rolls after first one
    public String handlePointPhase(int point) {
        System.out.println("Point: " + point);

        while (true){
            dice1 = rollDice();
            dice2 = rollDice();
            rollSum = dice1 + dice2;

            System.out.println("You rolled " + rollSum);

            if (rollSum == point) { //if player then rolls Point, player wins.
                System.out.println("Congratulations, you hit the point! You win!");
                return "win";
            } else if (rollSum == 7) { //if player hits 7 before rolling Point, player loses.
                System.out.println("Oh no, you rolled a 7! You lose!");
                return "lose";
            }
            else { //if neither win nor lose, player rolls again.
                System.out.println("Press Enter to Roll again");
                // Wait for the player to press Enter
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();  // Waits for user to hit Enter
            }
        }
    }

//Method to play game, manage bet and balance
    public void playGame(){
        playing = true;

        while (playing && balance > 0){
            betAmount = placeBet(); //place bet for round

            //Roll dice for first roll
            dice1 = rollDice();
            dice2 = rollDice();
            rollSum = dice1 + dice2;

            System.out.println("You rolled " + rollSum);

            String result = checkFirstRoll(rollSum);

            if (result == "win"){
                System.out.println("You win!");
                balance += betAmount; //add betted amount to balance
            }
            else if (result == "lose"){
                System.out.println("You lose!");
                balance -= betAmount; //Lose betted amount from balance
            }
            else {
                String pointResult = handlePointPhase(rollSum); //Call point phase method

                if (pointResult == "win"){
                    balance += betAmount;
                }
                else if (pointResult == "lose"){
                    balance -= betAmount;
                }
            }

            //Check balance to see if player can continue
            if (balance <= 0){
                System.out.println("Game Over!");
                playing = false;
                break;
            }

            //play again?
            playing = playAgain();
        }
    }

    //Method for playing again
    public boolean playAgain(){
        System.out.println("Would you like to play again? (y/n)");
        bet.nextLine();
        String answer = bet.nextLine();
        return answer.equals("y");
    }

    public static void main(String[] args) { //Main method to start game
        int startingBalance = 10000; //Start balance
        CrapsGame game = new CrapsGame(startingBalance);
        game.playGame();
    }
}