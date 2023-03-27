package pixformer.model.entity.dynamic;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentRetriever;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.collision.SolidCollisionComponent;
import pixformer.model.entity.powerup.PhysicalPowerup;
import pixformer.model.entity.powerup.PowerupBehaviour;
import pixformer.model.entity.powerup.powerups.FireFlower;
import pixformer.model.physics.PhysicsComponent;

import java.util.Optional;

/**
 * Represents the entity powerup fire flower. It remains still.
 */
public final class FlowerPowerupEntity extends AbstractEntity
        implements PhysicalPowerup, DefaultRectangleBoundingBoxEntity, DrawableEntity {
    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    private final GraphicsComponent graphicsComponent;
    private final PhysicsComponent physicsComponent = new PhysicsComponent(this);
    private final CollisionComponent collisionComponent = new SolidCollisionComponent(this);
    private final PowerupBehaviour powerupBehaviour = new FireFlower();
    /**
     * Constructor for the AbstractEntity.
     *
     * @param x      X coordinate
     * @param y      Y coordinate
     * @param graphicsComponent retriever for the graphics component
     */
    public FlowerPowerupEntity(final double x, final double y, final GraphicsComponentRetriever graphicsComponent) {
        super(x, y, WIDTH, HEIGHT);
        this.graphicsComponent = graphicsComponent.apply(this);
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
