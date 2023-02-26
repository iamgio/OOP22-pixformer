package pixformer.model.entity;

/**
 * Abstract class for an entity.
 */
public abstract class AbstractEntity implements Entity {
    private double x;
    private double y;
    private double width;
    private double height;

    /**
     * Constructor for the Entity.
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
        return this.y;
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
     * Set the X coordinate of the entity.
     * 
     * @param x the new X coordinate
     */
    protected void setX(final double x) {
        this.x = x;
    }

    /**
     * Set the Y coordinate of the entity.
     * 
     * @param y the new Y coordinate
     */
    protected void setY(final double y) {
        this.y = y;
    }

    /**
     * Set the widthof the entity.
     * 
     * @param width the new width
     */
    protected void setWidth(final double width) {
        this.width = width;
    }

    /**
     * Set the height of the entity.
     * 
     * @param height the new height
     */
    protected void setHeight(final double height) {
        this.height = height;
    }
}
