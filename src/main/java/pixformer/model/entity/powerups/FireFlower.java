package pixformer.model.entity.powerups;

import pixformer.model.entity.Entity;
/**
 * Class representing the FireFlower powerup.
 */
public class FireFlower implements PowerupBehaviour {

    private final int priority = 1;

    private final float fireballBaseSpeed = 0.01f;

    /**
     * {@inheritDoc}
     */
    @Override
    public void ability(final Entity entity) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPriority() {
        return priority;
    }

}
