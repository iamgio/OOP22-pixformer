package pixformer.model.score;

/**
 * Class to manage the player's score.
 */
public interface ScoreManager {

    /**
     * @return the score of the player
     */
    int getScore();

    /**
     * Update the score.
     *
     * @param points points to add at the score
     */
    void addScore(int points);

}
