package pixformer.model.entity.dynamic;

import pixformer.common.Vector2D;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.dynamic.ai.GoombaAI;
import pixformer.model.entity.powerup.PhysicalPowerup;
import pixformer.model.entity.powerup.PowerupBehaviour;
import pixformer.model.input.InputComponent;
import pixformer.model.modelinput.HorizontalModelInput;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Represents a powerUp entity which moves. It moves like a Goomba but its first direction is right.
 */
public final class MovingPowerupEntity extends AbstractEntity implements PhysicalPowerup, DefaultRectangleBoundingBoxEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;
    private static final double VELOCITY = 0.01;
    private final InputComponent inputComponent;
    private final PowerupBehaviour powerupBehaviour;

    /**
     * @param x its initial x position
     * @param y its initial y position
     * @param powerupBehaviour which this entity will represent.
     */
    public MovingPowerupEntity(final double x, final double y, final PowerupBehaviour powerupBehaviour) {
        super(x, y, WIDTH, HEIGHT);
        final Consumer<Vector2D> setter = new ProxyMutableEntity(this)::setVelocity;
        inputComponent = new GoombaAI(this, setter, VELOCITY, Entity::isSolid, HorizontalModelInput::right);
        this.powerupBehaviour = powerupBehaviour;
    }

    @Override
    public Optional<InputComponent> getInputComponent() {
        return Optional.of(inputComponent);
    }

    @Override
    public PowerupBehaviour getPowerupBehaviour() {
        return powerupBehaviour;
    }

}
