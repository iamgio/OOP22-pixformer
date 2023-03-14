package pixformer.model.score;

import pixformer.model.event.EventSubscriber;

/**
 * {@inheritDoc}.
 */
public class ScoreManagerImpl implements ScoreManager {
    private final Score score;

    /**
     * Costructor for the class.
     */
    public ScoreManagerImpl(final EventSubscriber eventSubscriber) {
        this.score = new ScoreImpl();
        eventSubscriber.addPlayerOnKill(entity -> this.score.addPoints(100));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getScore() {
        return this.score.getPoints();
    }

}
