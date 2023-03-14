package pixformer.model.entity.powerups.other.Fireball;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;

/**
 * Rapresenting fireball object spawned by player with FireFlower powerup.
 */
public class Fireball extends AbstractEntity implements DrawableEntity, DefaultRectangleBoundingBoxEntity {

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

    @Override
    public GraphicsComponent getGraphicsComponent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGraphicsComponent'");
    }
}
