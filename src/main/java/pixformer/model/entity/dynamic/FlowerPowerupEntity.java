package pixformer.model.entity.dynamic;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.powerup.PhysicalPowerup;
import pixformer.model.entity.powerup.PowerupBehaviour;
import pixformer.model.entity.powerup.powerups.FireFlower;

/**
 * Represents the entity powerup fire flower.
 */
public final class FlowerPowerupEntity extends AbstractEntity implements PhysicalPowerup, DefaultRectangleBoundingBoxEntity {
    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;
    /**
     * Constructor for the AbstractEntity.
     *
     * @param x      X coordinate
     * @param y      Y coordinate
     */
    public FlowerPowerupEntity(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
    }

    @Override
    public PowerupBehaviour getPowerupBehaviour() {
        return new FireFlower();
    }
}
