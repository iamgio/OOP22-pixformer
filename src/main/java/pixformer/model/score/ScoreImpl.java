package pixformer.model.score;

/**
 * {@inheritDoc}.
 */
public class ScoreImpl implements Score {

    private static final int DEFAULT_COINS_NUMBER = 3;

    private int points;
    private int coinsNumber;

    /**
     * Constructor for the class.
     */
    public ScoreImpl(final int points) {
        this.points = points;
        this.coinsNumber = DEFAULT_COINS_NUMBER;
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
    public void addPoints(final int points) {
        this.points += points;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRemainingCoins() {
        return this.coinsNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void grabCoin() {
        this.coinsNumber--;
    }
}
