package pixformer.model.entity.powerups;

import pixformer.common.Vector2D;
import pixformer.model.entity.Entity;
import pixformer.model.entity.powerups.other.Fireball.Fireball;
/**
 * Class representing the FireFlower powerup.
 */
public class FireFlower implements PowerupBehaviour {

    private final int priority = 2;

    private final float fireballBaseSpeed = 0.01f;

    /**
     * {@inheritDoc}
     */
    @Override
    public void ability(final Entity entity) {
        long fireballCount = entity.getWorld().get().getEntities().stream()
                            .filter(e -> e instanceof Fireball)
                            .count();

        if (fireballCount < 2) {
            Fireball fireball = new Fireball(entity.getX(), entity.getY(), entity.getWidth()/2, entity.getHeight()/2, fireballBaseSpeed, entity.getWorld().get());
            fireball.setVelocity(new Vector2D( entity.getVelocity().x()>=0?fireball.getSpeed():-fireball.getSpeed(), fireball.getVelocity().y()));
        }
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPriority() {
        return priority;
    }

}
