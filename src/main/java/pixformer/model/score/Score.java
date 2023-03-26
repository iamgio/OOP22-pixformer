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
     * @return the remaining coins to get in the game
     */
    int getCoins();

    /**
     * @param points points contained in the new score
     * @return a new Score with updated points quantity
     */
    Score copyWithPoints(int points);

    /**
     * @param points points to add at the old score
     * @return a new Score with an updated points quantity
     */
    Score copyAddPoints(int points);

    /**
     * @param coins coins contained in the new Score
     * @return a new Score with an updated number of coins
     */
    Score copyWithCoins(int coins);

    /**
     * @param coins coins to add to the old coins values
     * @return a new Score with an updated number of coins
     */
    Score copyAddCoins(int coins);
}
