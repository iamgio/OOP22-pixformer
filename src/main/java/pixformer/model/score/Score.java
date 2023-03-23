package pixformer.model.score;

/**
 * Score class to manage the in-game score of the user.
 */
public interface Score {

    /**
     * @return the score of the user
     */
    int getPoints();

    /**
     * Method to update the score adding a new value to the old value.
     *
     * @param points points to add
     */
    void addPoints(int points);

    /**
     * @return the remaining coins to get in the game
     */
    int getRemainingCoins();

    /**
     * Method to update the coins in the game, used when a player grab
     * a coin in the game.
     */
    void grabCoin();
}
