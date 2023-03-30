package pixformer.model.score;

import pixformer.model.entity.Entity;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.statics.Coin;
import pixformer.model.event.EventSubscriber;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;

/**
 * {@inheritDoc}.
 */
public class ScoreManagerImpl implements ScoreManager {
    private static final int DEFAULT_SCORE_INCREMENT = 100;
    private static final int POLE_POINTS_INCREMENT = 1_000;
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
            scoreMap.put(player, scoreMap.get(player).copyAddPoints(points));
        } else {
            scoreMap.put(player, new Score(points, 0));
        }
        if (entity instanceof Coin) {
            scoreMap.put(player, scoreMap.get(player).copyAddCoins(1));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Score getScore(final Entity entity) {
        return this.scoreMap.getOrDefault(entity, new Score(0, 0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Score> getAllScores() {
        return this.scoreMap.values().stream().toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTotalCoins() {
        return this.scoreMap.values().stream()
                .map(Score::coinsNumber)
                .filter(i -> i > 0)
                .reduce(Integer::sum).orElse(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void passedFinishLine(final Entity player) {
        if (player instanceof Player && !winners.contains(player)) {
            this.winners.add(player);
            this.increaseScore(player, player);
        }
    }

}
