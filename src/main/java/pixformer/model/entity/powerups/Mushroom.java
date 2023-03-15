package pixformer.model.entity.powerups;

/**
 * Class representing the Mushroom powerup.
 */
public class Mushroom implements PowerupBehaviour {

    private final int priority = 0;

    /**
     * {@inheritDoc}}
     */
    @Override
    public void ability() {
        return;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPriority() {
        return priority;
    }

}
