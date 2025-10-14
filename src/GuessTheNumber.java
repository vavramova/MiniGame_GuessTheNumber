/**
 *
 */
public class GuessTheNumber {
    public static void main(String[] args){
        System.out.println("Welcome to Guess the Number!");
        System.out.println("Let`s start!");

        int secretNum = (int)(Math.random() * 100) + 1;
        System.out.println("I generated a number!");
    }
}
