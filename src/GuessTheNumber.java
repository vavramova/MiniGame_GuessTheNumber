import java.util.Scanner;

/**
 *
 */
public class GuessTheNumber {
    public static void main(String[] args) {
        //Welcome message
        System.out.println("Welcome to Guess the Number!");
        System.out.println("Let`s start!");

        //Generating a random number
        int secretNum = (int) (Math.random() * 100) + 1;
        System.out.println("I generated a number!");

        //Choosing amount of tries
        System.out.println("Choose amount of tries: ");
        Scanner userMaxTriesInput = new Scanner(System.in);
        int maxTries = userMaxTriesInput.nextInt();

        //hints
        int attempts = 0;
        boolean guessed = false;
        while (attempts < maxTries) {
            System.out.println("Now it`s your turn to enter a number");
            Scanner userGuessInput = new Scanner(System.in);
            int userGuess = userGuessInput.nextInt();
            attempts++;


            if (userGuess == secretNum) {
                System.out.println("Congrats! You guessed the number!");
                guessed = true;
                break;
            } else if (userGuess < secretNum) {
                System.out.println("Try again! :( The number is bigger");
            } else {
                System.out.println("Try again! :( The number is smaller");
            }

            int attemptsLeft = maxTries - attempts;
            System.out.println("Attempts left: " + attemptsLeft);

        }

        if(!guessed) {
            System.out.println("Sorry! You have no attempts left! The number was " + secretNum);
        }
    }
}
