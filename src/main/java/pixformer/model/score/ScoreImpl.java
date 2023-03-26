package pixformer.model.score;

/**
 * {@inheritDoc}.
 */
public class ScoreImpl implements Score {
    private int points;
    private int coinsNumber;

    /**
     * Constructor for the class.
     */
    public ScoreImpl(final int points, final int coinsNumber) {
        this.points = points;
        this.coinsNumber = coinsNumber >= 0 ? coinsNumber : 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPoints() {
        return this.points;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCoins() {
        return this.coinsNumber;
    }

    /**
     * @param points points contained in the new score
     * @return a new Score with updated points quantity
     */
    @Override
    public Score copyWithPoints(final int points) {
        return new ScoreImpl(points, this.coinsNumber);
    }

    /**
     * @param points points to add at the old score
     * @return a new Score with an updated points quantity
     */
    @Override
    public Score copyAddPoints(final int points) {
        return new ScoreImpl(this.points + points, this.coinsNumber);
    }

    /**
     * @param coins coins contained in the new Score
     * @return a new Score with an updated number of coins
     */
    @Override
    public Score copyWithCoins(final int coins) {
        return new ScoreImpl(this.points, coins);
    }

    /**
     * @param coins coins to add to the old coins values
     * @return a new Score with an updated number of coins
     */
    @Override
    public Score copyAddCoins(final int coins) {
        return new ScoreImpl(this.points, this.coinsNumber + coins);
    }
}
