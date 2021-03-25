package guess_game;

/**
 * Karen Axon
 * This is free and unencumbered software released into the public domain.
 */

import java.util.Scanner;

/**
 * This is a guessing game. The program chooses a random number within 1 and 50
 * and the user has unlimited number of guesses. The user will be prompted for
 * a guess and will be informed if the guessed number is too high, too low or
 * correct. The user can play as many times as wanted and will be informed of
 * the number of guesses that he/she had at the end of the game.
 * @author Karen Axon
 * @version 1.0
 */

/**
 * The Game class mimics a guessing game. It creates a new SecretNumber instance
 * to run the game.
 */
public class Game {

    /**
     * The welcome method displays a message to standard output.
     */
    public static void welcome() {
        System.out.println("\nWelcome to the number guessing game!\n------" +
                "------------------------------\n" +
                "I selected a random number. Try to guess\nit. It is between " +
                "1 & 50 and you get \nunlimited tries. I'll tell you " +
                "if the\nguess is too high, too low or correct.");
    }

    /**
     * The goodbye method displays a message to standard output.
     */
    public static void goodbye() {
        System.out.println("\nThank you for playing. Goodbye!\n");
    }

    /**
     * The newInput method requests new input from the user.
     * @param keyboard Scanner for user input
     * @param  guess Invalid number
     * @return new user guess/input
     */
    public static int newInput(Scanner keyboard, int guess) {
        System.out.print("\n" + guess + " ins't between 1-50."
                + " Try again: ");
        guess = keyboard.nextInt(); // captures new user input
        // Consume next line
        keyboard.nextLine();

        return guess;
    }

    /**
     * The getInput method
     * @param keyboard Scanner for user input
     * @return user guess/input
     */
    public static int getInput(Scanner keyboard) {
        int input = 0;

        System.out.print("Enter your guess: ");
        input = keyboard.nextInt();
        keyboard.nextLine();

        return input;
    }

    public static void main(String[] args) {
        final int MAX = 50;
        final int MIN = 1;
        boolean winner = false;
        String repeatInput;
        char repeat = 'y';
        int input = 0;          // The guessed integer

        // Create a Scanner object to read input
        Scanner keyboard = new Scanner(System.in);

        // Display welcome
        welcome();

        do {
            // Start the game
            winner = false;

            //Create a new SecretNumber instance with the lower and upper bounds
            // for the random number
            SecretNumber game = new SecretNumber(MIN, MAX);

            // While there is no winner continue playing
            while (!winner) {

                input = getInput(keyboard);

                // If the input isn't between 1-50, ask for input again
                while (input < game.getRangeMinimum() ||
                        input > game.getRangeMaximum()) {
                    input = newInput(keyboard, input);
                }

                // Check to see if user guess is the same as random number
                winner= game.guess(input);
            }
            // Determine if user wants to play again
            System.out.print("\nWant to play again? Enter 'y' or 'n': ");
            repeatInput = keyboard.nextLine();
            repeat = repeatInput.charAt(0);

        } while (repeat == 'y' || repeat == 'Y');

        // Display goodbye
        goodbye();

        // Close Scanner
        keyboard.close();
    }

}
