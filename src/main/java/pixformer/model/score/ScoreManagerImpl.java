package pixformer.model.score;

public class ScoreManagerImpl implements ScoreManager{
    private final Score score;

    public ScoreManagerImpl() {
        this.score = new ScoreImpl();
        // TODO
        // Here i should specify the player this manager is linked to, and specify the events
        // it has to observe
    }

    /**
     * @return the score of the player
     */
    @Override
    public int getScore() {
        return this.score.getPoints();
    }
}
