package pixformer.model.entity.powerups;

/**
 * Class representing the FireFlower powerup.
 */
public class FireFlower implements PowerupBehaviour {

    private final int priority = 1;

    /**
     * {@inheritDoc}
     */
    @Override
    public void ability() {
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPriority() {
        return priority;
    }

}
