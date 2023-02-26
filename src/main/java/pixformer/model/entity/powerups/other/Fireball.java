package pixformer.model.entity.powerups.other;

import pixformer.common.Updatable;
import pixformer.common.Vector2D;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.BoundingBox;
import pixformer.model.entity.dynamics.Player;

/**
 * Rapresenting fireball object spawned by player with FireFlower powerup.
 */
public class Fireball extends AbstractEntity implements Updatable {

    static final double SPEED = 1.0;

    /**
     * 
     * @param p Player who spawned the fireball.
     */
    public Fireball(final Player p) {
        super(p.getX(), p.getY(), 1.0, 1.0);
        this.direction = p.getDirection();
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void update(final double dt) {
        updatePos(new Vector2D(SPEED * dt * (this.getDirection() == Direction.LEFT ? -1 : 1),0) ,dt);
    }

    @Override
    public BoundingBox getBoundingBox() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoundingBox'");
    }
}
