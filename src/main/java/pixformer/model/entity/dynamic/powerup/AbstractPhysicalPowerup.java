package pixformer.model.entity.dynamic.powerup;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.powerup.PhysicalPowerup;

/**
 * Implementation of a physical powerup entity.
 */
public abstract class AbstractPhysicalPowerup extends AbstractEntity implements PhysicalPowerup {

    private boolean consumed;

    /**
     * Instantiates a physical powerup entity.
     *
     * @param x      X coordinate
     * @param y      Y coordinate
     * @param width  width of the entity
     * @param height height of the entity
     */
    public AbstractPhysicalPowerup(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isConsumed() {
        return this.consumed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void consume() {
        this.consumed = true;
    }
}
