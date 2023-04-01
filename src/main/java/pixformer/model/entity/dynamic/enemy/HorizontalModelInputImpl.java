package pixformer.model.entity.dynamic.enemy;

import pixformer.common.Vector2D;
import pixformer.model.modelinput.HorizontalModelInput;

import java.util.function.Consumer;

/**
 * An HorizontalInputComponent which make the entity move left or right at the
 * same velocity module.
 */
public final class HorizontalModelInputImpl implements HorizontalModelInput {

    private final Vector2D rightVelocity;
    private final Vector2D leftVelocity;
    private final Consumer<Vector2D> velocitySetter;

    /**
     * Create a new HorizontalInputComponent.
     * 
     * @param velocitySetter for setting the desired velocity to the controlled entity.
     * @param velocity the module of the velocity which will be given to the entity.
     */
    public HorizontalModelInputImpl(final Consumer<Vector2D> velocitySetter, final double velocity) {
        this.velocitySetter = velocitySetter;
        final double velocityModule = Math.abs(velocity);
        rightVelocity = new Vector2D(velocityModule, 0);
        leftVelocity = new Vector2D(-velocityModule, 0);
    }

    @Override
    public void left() {
        velocitySetter.accept(leftVelocity);
    }

    @Override
    public void right() {
        velocitySetter.accept(rightVelocity);
    }

}
