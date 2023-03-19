package pixformer.model.entity.powerups;

import pixformer.common.Vector2D;
import pixformer.model.entity.Entity;
import pixformer.model.entity.powerups.other.fireball.Fireball;
/**
 * Class representing the FireFlower powerup.
 */
public class FireFlower implements PowerupBehaviour {
    private static final int PRIORITY = 2;

    private static final float FIREBALL_BASE_SPEED = 0.01f;

    /**
     * {@inheritDoc}
     */
    @Override
    public void ability(final Entity entity) {
        final long fireballCount = entity.getWorld().get().getEntities().stream()
                            .filter(e -> e instanceof Fireball)
                            .count();

        if (fireballCount < 2) {
            final Fireball fireball = new Fireball(entity.getX(), entity.getY(), entity.getWidth() / 2, entity.getHeight() / 2, FireFlower.FIREBALL_BASE_SPEED, entity.getWorld().get());
            fireball.setVelocity(new Vector2D(entity.getVelocity().x() >= 0 ? fireball.getSpeed() : -fireball.getSpeed(), fireball.getVelocity().y()));
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
