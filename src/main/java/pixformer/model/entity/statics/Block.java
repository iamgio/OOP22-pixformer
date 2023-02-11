package pixformer.model.entity.statics;

import pixformer.model.entity.GraphicsComponent;
import pixformer.common.Vector2D;
import pixformer.model.entity.DrawableEntity;

/**
 * {@inheritDoc}
 * Standard block in the world.
 */
public class Block implements DrawableEntity {

    private final double width;
    private final double height;
    private final Vector2D position;
    private final GraphicsComponent graphicsComponent;

    public Block(final Vector2D position, final double width, final double height,
                 final GraphicsComponent graphicsComponent) {
        this.width = width;
        this.height = height;
        this.position = position;
        this.graphicsComponent = graphicsComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getX() {
        return this.position.x();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getY() {
        return this.position.y();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getWidth() {
        return this.width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getHeight() {
        return this.height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }
}
