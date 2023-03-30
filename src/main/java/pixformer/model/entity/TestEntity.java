package pixformer.model.entity;

import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.input.InputComponent;
import pixformer.model.physics.PhysicsComponent;
import pixformer.view.engine.Color;
import pixformer.view.entity.RectangleGraphicsComponent;

import java.util.Optional;

/**
 * @deprecated test
 */
@Deprecated
public final class TestEntity extends AbstractEntity implements DrawableEntity, DefaultRectangleBoundingBoxEntity {

    private static final double SIZE = 1; // Test values

    private boolean hasCollided = false;

    private final InputComponent inputComponent;
    private final PhysicsComponent physicsComponent;
    private final CollisionComponent collisionComponent;
    private final GraphicsComponent graphicsComponent;

    /**
     * @param x X coordinate
     */
    public TestEntity(final double x) {
        super(x, 15, SIZE, SIZE);
        this.inputComponent = new TestInputComponent(this);
        this.collisionComponent = new TestCollisionComponent(this);
        this.graphicsComponent = new RectangleGraphicsComponent(this, new Color(1, 0, 0));
        this.physicsComponent = new PhysicsComponent(this);
    }

    @Override
    public Optional<InputComponent> getInputComponent() {
        return Optional.of(inputComponent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(collisionComponent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }

    /**
     * @return whether this entity has collided with another entity
     */
    public boolean hasCollided() {
        return this.hasCollided;
    }

    /**
     * @param hasCollided new colliding status
     */
    public void setHasCollided(final boolean hasCollided) {
        this.hasCollided = hasCollided;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<PhysicsComponent> getPhysicsComponent() {
        return Optional.of(this.physicsComponent);
    }
}
