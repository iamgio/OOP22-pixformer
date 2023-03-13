package pixformer.model.score;

import pixformer.model.entity.Entity;

/**
 * ScoreObserver for entities, manage their score update system.
 */
public class ScoreObserver {
    private final ScoreManager scoreManager;

    /**
     * Constructor for the observer.
     */
    public ScoreObserver() {
        this.scoreManager = new ScoreManagerImpl();
    }

    /**
     * Update method, update the observer.
     */
    public void update(final Entity entity) {
        scoreManager.addScore(100);
    }

}
