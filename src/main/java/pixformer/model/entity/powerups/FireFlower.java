package pixformer.model.entity.powerups;

import pixformer.common.Vector2D;
import pixformer.model.entity.Entity;
import pixformer.model.entity.powerups.other.fireball.Fireball;
/**
 * Class representing the FireFlower powerup.
 */
public class FireFlower implements PowerupBehaviour {
    private static final int PRIORITY = 2;
    private static final int MAX_ALIVE_FIREBALL = 2;
    private static final float FIREBALL_BASE_SPEED = 0.01f;

    /**
     * {@inheritDoc}
     */
    @Override
    public void ability(final Entity entity) {
        final long fireballCount = entity.getWorld().get().getEntities().stream()
                            .filter(e -> e instanceof Fireball)
                            .count();

        if (fireballCount < MAX_ALIVE_FIREBALL) {
            final float fireballSpeed =  entity.getVelocity().x() >= 0 ? FIREBALL_BASE_SPEED : -FIREBALL_BASE_SPEED;
            final Fireball fireball = new Fireball(entity.getX(), entity.getY(), entity.getWidth() / 2, entity.getHeight() / 2, fireballSpeed, entity.getWorld().get());
            entity.getWorld().get().spawnEntity(fireball);
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
