package pixformer.model.entity.dynamic;

import java.util.Optional;

import pixformer.common.Vector2D;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.dynamic.ai.GoombaAI;
import pixformer.model.input.InputComponent;
import pixformer.model.modelinput.HorizontalModelInput;
import pixformer.model.physics.PhysicsComponent;

/**
 * The default implementation of an enemy.
 */
public class Enemy extends AbstractEntity implements DefaultRectangleBoundingBoxEntity {

    private final GoombaAI ai;

    /**
     * Create a Goomba at position ({@code x}, {@code y}).
     * 
     * @param x coordinate
     * @param y coordinate.
     * @param width of the Enemy.
     * @param height of the Enemy.
     * @param velocity the module of the velocity of the Enemy.
     */
    public Enemy(final double x, final double y, final double width, final double height, final double velocity) {
        super(x, y, width, height);
        // joystick = new HorizontalModelInputImpl(this::fixVelocity, velocity);
        ai = new GoombaAI(this, this::fixVelocity, velocity);
    }

    @Override
    public final Optional<InputComponent> getInputComponent() {
        return Optional.of(ai);
    }

    private void fixVelocity(final Vector2D velocity) {
        final Vector2D current = super.getVelocity();
        final Vector2D newVelocity = new Vector2D(velocity.x(), current.y());
        this.setVelocity(newVelocity);
    }

    @Override
    public final Optional<PhysicsComponent> getPhysicsComponent() {
        return Optional.of(new PhysicsComponent(this));
    }

}
