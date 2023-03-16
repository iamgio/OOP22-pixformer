package pixformer.model.entity.powerups;

import pixformer.model.entity.Entity;
/**
 * Class representing the Mushroom powerup.
 */
public class Mushroom implements PowerupBehaviour {

    private final int priority = 1;

    /**
     * {@inheritDoc}}
     */
    @Override
    public void ability(final Entity entity) {
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
