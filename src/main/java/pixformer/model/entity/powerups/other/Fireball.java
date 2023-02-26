package pixformer.model.entity.powerups.other;

import pixformer.common.Updatable;
import pixformer.common.Vector2D;
import pixformer.model.entity.AbstractDrawableEntity;
import pixformer.model.entity.dynamics.Player;
import pixformer.model.entity.powerups.Powerup;

/**
 * Rapresenting fireball object spawned by player with FireFlower powerup.
 */
public class Fireball extends AbstractDrawableEntity implements Updatable {

    static final double SPEED = 1.0;

    /**
     * 
     * @param p Player who spawned the fireball.
     */
    public Fireball(final Player<Powerup> p) {
        super(p.getX(), p.getY(), 1.0, 1.0);
        this.direction = p.getDirection();
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void update(final double dt) {
        this.position = this.position.sum(new Vector2D(SPEED * dt * (this.getDirection() == Direction.LEFT ? -1 : 1), 0));
    }
}
