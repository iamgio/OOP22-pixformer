package pixformer.model.score;

import pixformer.model.entity.Entity;
import pixformer.model.event.EventSubscriber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@inheritDoc}.
 */
public class ScoreManagerImpl implements ScoreManager {
    private static final int DEFAULT_SCORE_INCREMENT = 100;
    private final Map<Entity, Score> scoreMap;

    /**
     * Constructor for the class.
     *
     * @param eventSubscriber subscriber for the score manager
     */
    public ScoreManagerImpl(final EventSubscriber eventSubscriber) {
        this.scoreMap = new HashMap<>();
        eventSubscriber.addPlayerOnKill(entity -> this.increaseScore(entity, DEFAULT_SCORE_INCREMENT));
    }

    private void increaseScore(final Entity player, final int score) {
        if (scoreMap.containsKey(player)) {
            scoreMap.get(player).addPoints(score);
        } else {
            scoreMap.put(player, new ScoreImpl(score));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getScore(final Entity entity) {
        return this.scoreMap.getOrDefault(entity, new ScoreImpl(0)).getPoints();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getAllScores() {
        return this.scoreMap.values().stream().map(Score::getPoints).toList();
    }

}
