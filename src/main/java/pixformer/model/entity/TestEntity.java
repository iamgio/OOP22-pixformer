package pixformer.model.entity;

import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.modelinput.CompleteModelInput;
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

    private final CompleteModelInput inputComponent;
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
    public double getX() {
        return this.x;
    }

    /**
     * Sets the X coordinate.
     * @param x X coordinate
     */
    public void setX(double x) {
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

    public Optional<CompleteModelInput> getInputComponent() {
        return Optional.of(inputComponent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }
}
