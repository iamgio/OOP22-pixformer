package pixformer.model.entity.powerups;

import pixformer.model.entity.Entity;
/**
 * Class representing the Mushroom powerup.
 */
public class Mushroom implements PowerupBehaviour {

    private static final int PRIORITY = 1;

    /**
     * {@inheritDoc}}
     */
    @Override
    public void ability(final Entity entity) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPriority() {
        return PRIORITY;
    }

}
