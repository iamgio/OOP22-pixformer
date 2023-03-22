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
    private static final int DEFAULT_COINS = 3;
    private final Map<Entity, Score> scoreMap;
    private int coinsNumber;

    /**
     * Constructor for the class.
     *
     * @param eventSubscriber subscriber for the score manager
     */
    public ScoreManagerImpl(final EventSubscriber eventSubscriber) {
        this.scoreMap = new HashMap<>();
        this.coinsNumber = DEFAULT_COINS;
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
            this.coinsNumber--;
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

    @Override
    public int getRemainingCoins() {
        return this.coinsNumber;
    }

}
