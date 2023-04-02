package pixformer.model.score;

import pixformer.model.entity.Entity;

import java.util.List;

/**
 * Class to manage multiple {@link Score} for multiple player.
 */
public interface ScoreManager {

    /**
     * @param entity entity to see the score
     * @return the score of a specific player
     */
    Score getScore(Entity entity);

    /**
     * @param playerIndex index of the player
     * @return the score of the player with a certain index
     */
    Score getScoreByIndex(int playerIndex);

    /**
     * @return a list containing the scores of each player
     */
    List<Score> getAllScores();

    /**
     * @return the remaining coins in the game
     */
    int getTotalCoins();

    /**
     * Method to manage when a player hit the finish line.
     * @param player player who passed the end flag
     */
    void passedFinishLine(Entity player);

}
