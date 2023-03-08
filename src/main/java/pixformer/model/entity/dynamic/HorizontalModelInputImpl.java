package pixformer.model.entity.dynamic;

import pixformer.common.Vector2D;
import pixformer.model.entity.Entity;
import pixformer.model.modelinput.HorizontalModelInput;

/**
 * An HorizontalInputComponent which make the entity move left or right at the
 * same velocity module.
 */
public class HorizontalModelInputImpl implements HorizontalModelInput {

    private final Vector2D rightVelocity;
    private final Vector2D leftVelocity;
    private final Entity entity;

    /**
     * Create a new HorizontalInputComponent.
     * 
     * @param entity   which will be controlled by this object.
     * @param velocity the module of the velocity which will be given to the
     *                 {@code entity}.
     */
    public HorizontalModelInputImpl(final Entity entity, final double velocity) {
        this.entity = entity;
        final double velocityModule = Math.abs(velocity);
        rightVelocity = new Vector2D(velocityModule, 0);
        leftVelocity = new Vector2D(-velocityModule, 0);
    }

    @Override
    public void left() {
        entity.setVelocity(leftVelocity);
    }

    @Override
    public void right() {
        entity.setVelocity(rightVelocity);
    }

}
