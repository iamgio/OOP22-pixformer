package pixformer.model.entity.dynamic;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentRetriever;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.powerup.PhysicalPowerup;
import pixformer.model.entity.powerup.PowerupBehaviour;
import pixformer.model.entity.powerup.powerups.FireFlower;
import pixformer.model.physics.PhysicsComponent;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Represents the entity powerup fire flower.
 */
public final class FlowerPowerupEntity extends AbstractEntity implements PhysicalPowerup, DefaultRectangleBoundingBoxEntity, DrawableEntity {
    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    private final GraphicsComponent graphicsComponent;
    /**
     * Constructor for the AbstractEntity.
     *
     * @param x      X coordinate
     * @param y      Y coordinate
     */
    public FlowerPowerupEntity(final double x, final double y, final GraphicsComponentRetriever graphicsComponent) {
        super(x, y, WIDTH, HEIGHT);
        this.graphicsComponent = graphicsComponent.apply(this);
    }

    @Override
    public PowerupBehaviour getPowerupBehaviour() {
        return new FireFlower();
    }

    @Override
    public GraphicsComponent getGraphicsComponent() {
        return graphicsComponent;
    }

    @Override
    public Optional<PhysicsComponent> getPhysicsComponent() {
        return Optional.of(new PhysicsComponent(this));
    }
}
