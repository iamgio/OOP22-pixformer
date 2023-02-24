package pixformer.model.score;

/**
 * {@inheritDoc}.
 */
public class ScoreImpl implements Score {
    private int points;

    /**
     * Constructor for the class.
     */
    public ScoreImpl() {
        this.points = 0;
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
}
