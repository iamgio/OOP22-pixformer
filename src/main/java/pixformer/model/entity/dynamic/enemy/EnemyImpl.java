package pixformer.model.entity.dynamic.enemy;

import pixformer.common.Vector2D;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.dynamic.enemy.ai.GoombaAI;
import pixformer.model.input.InputComponent;
import pixformer.model.physics.PhysicsComponent;

import java.util.Optional;

/**
 * The default implementation of an enemy.
 */
public class EnemyImpl extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, Enemy {

    private final GoombaAI ai;
    private final double velocityModule;

    /**
     * Create a Goomba at position ({@code x}, {@code y}).
     * 
     * @param x coordinate
     * @param y coordinate.
     * @param width of the Enemy.
     * @param height of the Enemy.
     * @param velocity the module of the velocity of the Enemy.
     */
    public EnemyImpl(final double x, final double y, final double width, final double height, final double velocity) {
        super(x, y, width, height);
        this.velocityModule = velocity;
        // joystick = new HorizontalModelInputImpl(this::fixVelocity, velocity);
        ai = new GoombaAI(this, this::fixVelocity, velocity);
    }

    @Override
    public final Optional<InputComponent> getInputComponent() {
        return Optional.of(ai);
    }

    private void fixVelocity(final Vector2D velocity) {
        final double newX = velocity.x();
        final double oldX = getVelocity().x();
        setVelocity(getVelocity().copyWithX(oldX > 0
                ? Math.min(velocityModule, newX) : Math.max(-velocityModule, newX)
        ));
    }

    @Override
    public final Optional<PhysicsComponent> getPhysicsComponent() {
        return Optional.of(new PhysicsComponent(this));
    }

}
