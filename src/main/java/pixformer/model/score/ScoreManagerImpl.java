package pixformer.model.score;

/**
 * {@inheritDoc}.
 */
public class ScoreManagerImpl implements ScoreManager {
    private final Score score;

    /**
     * Costructor for the class.
     */
    public ScoreManagerImpl() {
        this.score = new ScoreImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getScore() {
        return this.score.getPoints();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addScore(final int points) {
        this.score.addPoints(points);
    }
}
