package pixformer.model.entity.statics;

import pixformer.common.Vector2D;
import pixformer.model.entity.DrawableEntity;

/**
 * {@inheritDoc}
 * Brick block, common block which can be destroyed.
 */
public class Brick implements DrawableEntity {
    private double width;
    private double height;
    private Vector2D position;
    // private final GraphicComponent graphComponent

    public Brick (final Vector2D position, final double width, final double height) {
        this.width = width;
        this.height = height;
        this.position = position;
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
}
