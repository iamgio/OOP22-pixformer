package pixformer.model.entity.powerup.powerups;

import pixformer.model.entity.Entity;
import pixformer.model.entity.EntityFactory;
import pixformer.model.entity.powerup.PowerupBehaviour;
import pixformer.model.entity.powerup.other.fireball.Fireball;
/**
 * Class representing the FireFlower powerup.
 */
public class FireFlower implements PowerupBehaviour {
    private static final int PRIORITY = 2;
    private static final int MAX_FIREBALL_ALIVE = 2;

    /**
     * {@inheritDoc}
     */
    @Override
    public void ability(final Entity entity, final EntityFactory entityFactory) {
        final long fireballCount = entity.getWorld().get().getEntities().stream()
                            .filter(e -> e instanceof Fireball)
                            .count();

        if (fireballCount < MAX_FIREBALL_ALIVE) {
            entity.getWorld().get().queueEntitySpawn(entityFactory.createFireball(entity));
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPriority() {
        return PRIORITY;
    }

}
