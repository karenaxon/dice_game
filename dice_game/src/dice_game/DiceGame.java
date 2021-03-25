package dice_game;

/**
 * Karen Axon
 * This is free and unencumbered software released into the public domain.
 */

import java.util.Random;
import java.util.Scanner;

/**
 * This program mimics a dice game and is played between the computer and
 * the user. Both of the players have their own die and take turns rolling
 * it, which counts as a round. There are 10 rounds. The player with the
 * higher roll wins the round and the player who wins the most rounds is the
 * grand winner. If there is a tie during a round, or at the end of the game,
 * nobody wins.
 *
 * @author Karen Axon
 * @version 1.0
 */

/**
 * The DiceGame class mimics a dice game
 */
public class DiceGame {

    /**
     * The goodbye method displays a message to standard output.
     */
    public static void goodbye(){
        System.out.println("\nThank you for playing my game. Goodbye!");
    }

    /**
     * The welcome method displays a message to standard output.
     */
    public static void welcome() {
        System.out.println("\nThis is a game of you versus me (the computer)" +
                ".\nWe will each have one die. We roll our own die\nand the " +
                "higher number wins. We roll ten times\nand the one with the " +
                "higher number of wins is\nthe grand winner. When there is a " +
                "tie, there\nis no winner.");
    }

    public static void main(String[] args) {
        final int MAX_ROLLS = 10;
        final int MAX_PER_HUNDRED = 100;
        int randPercentage;
        int compWins = 0, userWins = 0;

        // Create a random number to determine if the die will be a regular roll
        // (1-6) or if it will be a loaded die (30% of the time it will roll a 6
        // for the computer or a 1 for the user).
        Random random = new Random();
        randPercentage = random.nextInt(MAX_PER_HUNDRED);

        // Dice used by computer
        LoadedDie die1 = new LoadedDie(6, randPercentage);

        // Dice used by the user
        LoadedDie die2 = new LoadedDie(1, randPercentage);

        // Display welcome message
        welcome();

        // Create a Scanner
        Scanner keyboard = new Scanner(System.in);

        // Play 10 rounds
        for (int i = 0; i < MAX_ROLLS; i++) {
            System.out.println("\nRoll " + (i + 1) + " of " + MAX_ROLLS + ":");

            // Computer rolls die
            die1.roll();
            System.out.println("I rolled a " + die1.getNumber());

            // Ask user to press enter to roll his/her die
            System.out.print("Ready to roll? Press 'Enter' when ready: ");
            keyboard.nextLine();

            // User rolls die
            die2.roll();
            System.out.println("You rolled a " + die2.getNumber());

            // Keep track of who wins the round, no winner for a tie
            if(die1.getNumber() > die2.getNumber())
                compWins++;
            else if(die2.getNumber() > die1.getNumber())
                userWins++;
            else
                System.out.println("That was a tie! No winner this round.");
        }

        // Display results of the game
        System.out.println("\nI won " + compWins + " times.\nYou won " +
                userWins + " times.");
        if(compWins > userWins)
            System.out.println("I am the grand winner!");
        else if(userWins > compWins)
            System.out.println("You are the grand winner!");
        else
            System.out.println("It was a tie. There is no winner.");

        // Close Scanner
        keyboard.close();

        // Display goodbye message
        goodbye();
    }
}
