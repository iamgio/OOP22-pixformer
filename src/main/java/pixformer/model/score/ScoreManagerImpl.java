package pixformer.model.score;

import pixformer.model.entity.Entity;
import pixformer.model.entity.statics.Coin;
import pixformer.model.event.EventSubscriber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@inheritDoc}.
 */
public class ScoreManagerImpl implements ScoreManager {
    private static final int DEFAULT_SCORE_INCREMENT = 100;
    private static final int DEFAULT_REMAINING_COINS = 3;
    private final Map<Entity, Score> scoreMap;

    /**
     * Constructor for the class.
     *
     * @param eventSubscriber subscriber for the score manager
     */
    public ScoreManagerImpl(final EventSubscriber eventSubscriber) {
        this.scoreMap = new HashMap<>();
        eventSubscriber.addPlayerOnKill(this::increaseScore);
    }

    /**
     * Method to update the score of a specific player.
     * @param player player to update the score
     * @param entity entity killed
     */
    private void increaseScore(final Entity player, final Entity entity) {
        if (scoreMap.containsKey(player)) {
            scoreMap.get(player).addPoints(DEFAULT_SCORE_INCREMENT);
        } else {
            scoreMap.put(player, new ScoreImpl(DEFAULT_SCORE_INCREMENT));
        }
        if (entity instanceof Coin) {
            scoreMap.get(player).grabCoin();
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRemainingCoins() {
        return this.scoreMap.values().stream()
                .map(Score::getRemainingCoins)
                .filter(i -> i > 0)
                .reduce(Integer::sum).orElse(DEFAULT_REMAINING_COINS);
    }

}
