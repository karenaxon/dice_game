package guess_game;

/**
 * The SecretNumber class creates a random number, processes the user's guess to
 * determine if it is correct and displays messages to keep the user informed.
 */
public class SecretNumber {
    private int MIN;            // The lower bound number for the guess.
    private int MAX;            // The upperbound number for the guess.
    private int randNumber;     // Number that is trying to be guessed.
    private int count = 0;      // The number of guesses.

    /**
     * Constructor
     * @param low The lower bound number for the guess.
     * @param high The upperbound number for the guess.
     */
    public SecretNumber(int low, int high){
        MIN = low;
        MAX = high;
        this.randNumber = randNumber;
        this.count = count;

        newTarget();
    }

    /**
     * The getRangeMinimum returns an integer.
     * @return The lower bound number for the guess.
     */
    public int getRangeMinimum() {
        // returns the low end of the range used by newTarget
        return MIN;
    }

    /**
     * The getRangeMaximum returns an integer.
     * @return The upper bound number for the guess.
     */
    public int getRangeMaximum() {
        // returns the high end of the range used by newTarget
        return MAX;
    }

    /**
     * The newTarget method creates a random number.
     */
    public void newTarget() {
        // Create random number
        randNumber = ((int) (Math.random() *
                ((getRangeMaximum() - getRangeMinimum()) + 1) +
                getRangeMinimum()));
    }

    /**
     * The guess method processes the user's guess.
     * @param num The integer guess input from the user.
     * @return boolean true or false based on the guess.
     */
    public boolean guess(int num) {
        // Add one guessing try the variable
        count++;

        // Processes the user's guess
        if (num == randNumber) {
            System.out.println("\nMy number was " + randNumber + " and you " +
                    "guessed it. Good job!");
            displayStatistics();
            return true;
        } else {
            displayHint(num);
            return false;
        }
    }

    /**
     * The displayHint method displays a message to standard output.
     * @param num The integer guess input from the user.
     */
    private void displayHint(int num) {
        // Displays whether the guess was too high or too low
        if (num > randNumber)
            System.out.println("\nYour guess is too high. Try again!");
        else
            System.out.println("\nYour guess is too low. Try again!");
    }

    /**
     * The displayStatistics method displays a message to standard output.
     */
    public void displayStatistics() {
        // Displays number of guesses
        System.out.println("Your valid guesses (between 1 & 50) were: "
                + count + ".");
    }

}
