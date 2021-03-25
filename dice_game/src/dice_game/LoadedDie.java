package dice_game;

import java.util.Random;

/**
 *  The LoadedDie class simulates a six-sided die and a loaded die when
 *  appropriate.
 */
public class LoadedDie {
    private final int DIE_SIDES = 6;  // The upper bound for the random number
    private int moreTimesPerHundred;  // If less than 30% (<= 29) use loaded die
    private int loadedNumber;         // 6 for computer and 1 for user
    private int number;               // The loaded or random number


    /**
     * The constructor performs an initial roll of the die.
     * @param loadedNumber        which number should come up more often
     * @param moreTimesPerHundred how many times per 100 rolls to come up with
     *                            the loaded number (instead of uniform random)
     */
    public LoadedDie(int loadedNumber, int moreTimesPerHundred ) {
        this.loadedNumber = loadedNumber;
        this.moreTimesPerHundred = moreTimesPerHundred;

        roll();
    }

    /**
     * The roll method simulates the rolling of the die.
     * It will typically set this die's value to a random value
     * with uniform distribution between 1 and 6. Occasionally,
     * it will a priori return the favored value (with frequency
     * determined by the moreTimesPerHundred argument that was passed
     * to the constructor).
     */
    public void roll() {
        // 30% of the time the loaded number (computer 6, user 1) will be
        // used instead of a random number. The other 70% of the time a
        // random number will be generated.
        if (moreTimesPerHundred <= 29)
            number = loadedNumber;
        else {
            // Create a random number
            Random rand = new Random();
            number = rand.nextInt(DIE_SIDES) + 1;
        }
    }

    /**
     * getSides method
     * @return The number of sides for the die
     */
    public int getSides() {
        return DIE_SIDES;
    }

    /**
     * getRandNum method
     * @return The value of the die
     */
    public int getNumber(){
        return number;
    }
}
