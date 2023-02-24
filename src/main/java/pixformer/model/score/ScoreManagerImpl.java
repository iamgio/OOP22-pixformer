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
        // TODO
        // Here i should specify the player this manager is linked to, and specify the events
        // it has to observe
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getScore() {
        return this.score.getPoints();
    }
}
