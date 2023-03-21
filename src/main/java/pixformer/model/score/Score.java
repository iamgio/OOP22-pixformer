package pixformer.model.score;

/**
 * Score class to manage the in-game score of the user.
 */
public interface Score {

    /**
     * @return the score of the user
     */
    int getPoints();

    /**
     * Method to update the score adding a new value to the old value.
     *
     * @param points points to add
     */
    void addPoints(int points);
}
