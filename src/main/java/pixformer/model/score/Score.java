package pixformer.model.score;

/**
 * In-game score, record for all the score features in the game.
 *
 * @param points points of the score
 * @param coinsNumber number of coins token
 */
public record Score(int points, int coinsNumber) {

    /**
     * Method to get a new Score with the same coins but different points.
     *
     * @return a new Score with updated points
     */
    public Score copyWithPoints(final int points) {
        return new Score(points, this.coinsNumber);
    }

    /**
     * Method to get a new Score with the same coins but different points.
     *
     * @return a new Score with added points from the old value
     */
    public Score copyAddPoints(final int points) {
        return new Score(this.points + points, this.coinsNumber);
    }

    /**
     * Method to get a new Score with the same points but different coins.
     *
     * @return a new Score with updated coins
     */
    public Score copyWithCoins(final int coins) {
        return new Score(this.points, coins);
    }

    /**
     * Method to get a new Score with the same points but different coins.
     *
     * @return a new Score with an updated value added from the old value
     */
    public Score copyAddCoins(final int coins) {
        return new Score(this.points, this.coinsNumber + coins);
    }
}
