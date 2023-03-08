package pixformer.model.entity.dynamic;

import pixformer.common.Vector2D;
import pixformer.model.entity.Entity;
import pixformer.model.input.InputComponent;
import pixformer.model.modelinput.HorizontalModelInput;

/**
 * An HorizontalInputComponent which make the entity move left or right at the
 * same velocity module.
 */
public class HorizontalInputComponent extends InputComponent implements HorizontalModelInput {

    private final Vector2D rightVelocity;
    private final Vector2D leftVelocity;

    /**
     * Create a new HorizontalInputComponent.
     * 
     * @param entity   which will be controlled by this object.
     * @param velocity the module of the velocity which will be given to the
     *                 {@code entity}.
     */
    public HorizontalInputComponent(final Entity entity, final double velocity) {
        super(entity);
        final double velocityModule = Math.abs(velocity);
        rightVelocity = new Vector2D(velocityModule, 0);
        leftVelocity = new Vector2D(-velocityModule, 0);
    }

    @Override
    public void left() {
        super.getEntity().setVelocity(leftVelocity);
    }

    @Override
    public void right() {
        super.getEntity().setVelocity(rightVelocity);
    }

}
