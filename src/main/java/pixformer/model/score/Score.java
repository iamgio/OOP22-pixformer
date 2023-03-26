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

    Score copyWithPoints(int points);

    Score copyAddPoints(int points);

    Score copyWithCoins(int coins);

    Score copyAddCoins(int coins);
}
