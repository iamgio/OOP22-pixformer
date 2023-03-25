package pixformer.model.score;

import pixformer.model.entity.Entity;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.statics.Coin;
import pixformer.model.event.EventSubscriber;

import java.util.*;

/**
 * {@inheritDoc}.
 */
public class ScoreManagerImpl implements ScoreManager {
    private static final int DEFAULT_SCORE_INCREMENT = 100;
    private static final int POLE_POINTS_INCREMENT = 1_000;
    private static final int DEFAULT_REMAINING_COINS = 3;
    private final Map<Entity, Score> scoreMap;
    private final Set<Entity> winners;

    /**
     * Constructor for the class.
     *
     * @param eventSubscriber subscriber for the score manager
     */
    public ScoreManagerImpl(final EventSubscriber eventSubscriber) {
        this.scoreMap = new HashMap<>();
        this.winners = new HashSet<>();
        eventSubscriber.addPlayerOnKill(this::increaseScore);
    }

    /**
     * Method to update the score of a specific player.
     * @param player player to update the score
     * @param entity entity killed
     */
    private void increaseScore(final Entity player, final Entity entity) {
        int points = !entity.equals(player) ? DEFAULT_SCORE_INCREMENT : POLE_POINTS_INCREMENT / winners.size();
        if (scoreMap.containsKey(player)) {
            scoreMap.get(player).addPoints(points);
        } else {
            scoreMap.put(player, new ScoreImpl(points));
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void passedFinishLine(final Player player) {
        if (!winners.contains(player)) {
            this.winners.add(player);
            this.increaseScore(player, player);
        }
    }

}
