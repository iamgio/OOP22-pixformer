package pixformer.model.entity;

import pixformer.view.entity.GraphicsComponent;
import pixformer.view.entity.TestGraphicsComponent;

import java.util.Optional;

/**
 * @deprecated test
 */
public class TestEntity implements Entity {

    private static final double POS = 10;
    private static final double SIZE = 1; // Test values

    /**
     * {@inheritDoc}
     */
    @Override
    public double getX() {
        return POS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getY() {
        return POS;
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
