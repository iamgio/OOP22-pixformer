package pixformer.model.entity.dynamic;

import pixformer.common.Vector2D;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponentRetriever;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.collision.SolidCollisionComponent;
import pixformer.model.entity.collision.SolidEntity;
import pixformer.model.entity.dynamic.ai.GoombaAI;
import pixformer.model.entity.powerup.PhysicalPowerup;
import pixformer.model.entity.powerup.PowerupBehaviour;
import pixformer.model.input.InputComponent;
import pixformer.model.modelinput.HorizontalModelInput;
import pixformer.model.physics.PhysicsComponent;
import pixformer.model.entity.GraphicsComponentRetriever;
import pixformer.model.entity.Entity;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Represents a powerUp entity which moves. It moves like a Goomba but its first direction is right.
 */
public final class MovingPowerupEntity extends AbstractEntity
        implements PhysicalPowerup, DefaultRectangleBoundingBoxEntity, DrawableEntity, SolidEntity {


    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;
    private static final double VELOCITY = 0.003;
    private final PowerupBehaviour powerupBehaviour;
    private final InputComponent inputComponent;
    private final GraphicsComponent graphicsComponent;
    private final PhysicsComponent physicsComponent = new PhysicsComponent(this);
    private final CollisionComponent collisionComponent = new SolidCollisionComponent(this);

    /**
     * @param x its initial x position
     * @param y its initial y position
     * @param powerupBehaviour which this entity will represent
     * @param graphicsComponent retriever for the graphics component of the entity
     */
    public MovingPowerupEntity(final double x, final double y, final PowerupBehaviour powerupBehaviour,
                               final GraphicsComponentRetriever graphicsComponent) {
        super(x, y, WIDTH, HEIGHT);
        final Consumer<Vector2D> setter = new ProxyMutableEntity(this)::setVelocity;
        inputComponent = new GoombaAI(this, setter, VELOCITY, Entity::isSolid, HorizontalModelInput::right);
        this.powerupBehaviour = powerupBehaviour;
        this.graphicsComponent = graphicsComponent.apply(this);
    }

    @Override
    public Optional<InputComponent> getInputComponent() {
        return Optional.of(inputComponent);
    }

    @Override
    public PowerupBehaviour getPowerupBehaviour() {
        return powerupBehaviour;
    }

    @Override
    public GraphicsComponent getGraphicsComponent() {
        return graphicsComponent;
    }
    @Override
    public Optional<PhysicsComponent> getPhysicsComponent() {
        return Optional.of(physicsComponent);
    }

    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(collisionComponent);
    }
}
