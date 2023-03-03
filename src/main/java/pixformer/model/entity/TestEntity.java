package pixformer.model.entity;

import pixformer.model.World;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.input.InputComponent;
import pixformer.view.entity.TestGraphicsComponent;

import java.util.Optional;

/**
 * @deprecated test
 */
@Deprecated
public class TestEntity implements DrawableEntity, DefaultRectangleBoundingBoxEntity {

    private static final double SIZE = 1; // Test values

    // Il campo X andrà in Entity (classe astratta)
    private double x;

    private boolean hasCollided = false;

    private final InputComponent inputComponent;
    private final GraphicsComponent graphicsComponent;

    /**
     * @param x X coordinate
     */
    public TestEntity(final double x) {
        this.x = x;
        this.inputComponent = new TestInputComponent(this);
        this.graphicsComponent = new TestGraphicsComponent(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSpawn(final World world) {
        world.getCollisionManager().addOnCollide(this, other -> hasCollided = true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getX() {
        return this.x;
    }

    /**
     * Sets the X coordinate.
     * @param x X coordinate
     */
    public void setX(final double x) {
        this.x = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getY() {
        return 15;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getWidth() {
        return SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getHeight() {
        return SIZE;
    }

    @Override
    public Optional<InputComponent> getInputComponent() {
        return Optional.of(inputComponent);
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
}
