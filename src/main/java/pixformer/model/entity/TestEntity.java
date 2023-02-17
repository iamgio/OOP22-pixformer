package pixformer.model.entity;

import pixformer.view.entity.GraphicsComponent;
import pixformer.view.entity.TestGraphicsComponent;

import java.util.Optional;

/**
 * @deprecated test
 */
public class TestEntity implements Entity {

    private static final double SIZE = 1; // Test values

    private final double x;

    /**
     * @param x X coordinate
     */
    public TestEntity(final double x) {
        this.x = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getX() {
        return this.x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getY() {
        return 0;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<GraphicsComponent> getGraphicsComponent() {
        return Optional.of(new TestGraphicsComponent(this));
    }
}
