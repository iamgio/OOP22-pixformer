package pixformer.model.score;

/**
 * {@inheritDoc}.
 */
public class ScoreImpl implements Score {
    private int points;
    private int coinsNumber;

    /**
     * Constructor for the class.
     *
     * @param points points of the class
     * @param coinsNumber coins of the class
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
     * {@inheritDoc}
     */
    @Override
    public Score copyWithPoints(final int points) {
        return new ScoreImpl(points, this.coinsNumber);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Score copyAddPoints(final int points) {
        return new ScoreImpl(this.points + points, this.coinsNumber);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Score copyWithCoins(final int coins) {
        return new ScoreImpl(this.points, coins);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Score copyAddCoins(final int coins) {
        return new ScoreImpl(this.points, this.coinsNumber + coins);
    }
}
