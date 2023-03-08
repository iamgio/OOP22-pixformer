package pixformer.model.entity;

import pixformer.common.Vector2D;

/**
 * Abstract class for a mutable entity.
 */
public abstract class AbstractEntity implements Entity {

    private double x;
    private double y;
    private double width;
    private double height;
    private Vector2D velocity;

    /**
     * Constructor for the AbstractEntity.
     *
     * @param x      X coordinate
     * @param y      Y coordinate
     * @param width  width of the entity
     * @param height height of the entity
     */
    protected AbstractEntity(final double x, final double y, final double width, final double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocity = new Vector2D(0, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getX() {
        return this.x;
    }

    /**
     * Set the X coordinate of the entity.
     *
     * @param x the new X coordinate
     */
    public void setX(final double x) {
        this.x = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getY() {
        return this.y;
    }

    /**
     * Set the Y coordinate of the entity.
     *
     * @param y the new Y coordinate
     */
    public void setY(final double y) {
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getWidth() {
        return this.width;
    }

    /**
     * Set the width of the entity.
     *
     * @param width the new width
     */
    public void setWidth(final double width) {
        this.width = width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getHeight() {
        return this.height;
    }

    /**
     * Set the height of the entity.
     *
     * @param height the new height
     */
    public void setHeight(final double height) {
        this.height = height;
    }

    /**
     * {@inheritDoc}
     */
    public Vector2D getVelocity() {
        return new Vector2D(this.velocity.x(), this.velocity.y());
    }

    /**
     * Set the new velocity of the entity.
     *
     * @param velocity the new velocity
     */
    public void setVelocity(final Vector2D velocity) {
        this.velocity = velocity;
    }
}
