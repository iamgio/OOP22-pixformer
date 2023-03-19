package pixformer.model.score;

import pixformer.model.event.EventSubscriber;

/**
 * {@inheritDoc}.
 */
public class ScoreManagerImpl implements ScoreManager {
    private final Score score;

    /**
     * Constructor for the class.
     *
     * @param eventSubscriber subscriber for the score manager
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
