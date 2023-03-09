package pixformer.model.entity.powerups.other;

import pixformer.common.Updatable;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.Vector2D;
import pixformer.model.entity.collision.BoundingBox;

/**
 * Rapresenting fireball object spawned by player with FireFlower powerup.
 */
public class Fireball extends AbstractEntity implements Updatable {

    static final double SPEED = 1.0;

    /**
     * 
     * @param x Starting X position.
     * @param y Starting Y position.
     * @param width Width.
     * @param height Height.
     */
    public Fireball(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void update(final double dt) {
        //updatePos(new Vector2D(SPEED * dt * (this.getDirection() == Direction.LEFT ? -1 : 1), 0), dt);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BoundingBox getBoundingBox() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoundingBox'");
    }
}
