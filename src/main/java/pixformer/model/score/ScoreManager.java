package pixformer.model.score;

import pixformer.model.entity.Entity;

import java.util.List;

/**
 * Class to manage the player's score.
 */
public interface ScoreManager {

    /**
     * @return the score of the player
     */
    int getScore(Entity entity);

    /**
     * @return a list containing the ordered scores of each player
     */
    List<Integer> getAllScores();

}
