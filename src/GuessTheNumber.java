import java.util.Scanner;

/**
 *
 */
public class GuessTheNumber {
    public static void main(String[] args){
        //Welcome message
        System.out.println("Welcome to Guess the Number!");
        System.out.println("Let`s start!");

        //Generating a random number
        int secretNum = (int)(Math.random() * 100) + 1;
        System.out.println("I generated a number!");

        //Reading user`s Number
        System.out.println("Now it`s your turn to enter a number");
        Scanner userInput = new Scanner(System.in);
        int userGuess = userInput.nextInt();

        System.out.println("Your guess: " + userGuess);

        //hint
        if(userGuess == secretNum){
            System.out.println("Congrats! You guessed the number!");
        }else if(userGuess < secretNum){
            System.out.println("Try again! :( The number is bigger");
        }else {
            System.out.println("Try again! :( The number is smaller");
        }

        }

    }

