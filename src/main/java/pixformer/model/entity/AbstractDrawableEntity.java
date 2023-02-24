package pixformer.model.entity;

/**
 * Abstract class for a drawable entity.
 */
public class AbstractDrawableEntity implements DrawableEntity{ 
    
    public enum Direction{
        LEFT,
        RIGHT
    }

    protected Direction direction;

    protected double x;
    protected double y;
    protected double width;
    protected double height;

    /**
     * Constructor for the Entity.
     * @param x X coordinate
     * @param y Y coordinate
     * @param width width of the entity
     * @param height height of the entity
     */
    protected AbstractDrawableEntity(final double x, final double y, final double width, final double height) {
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

    @Override
    public GraphicsComponent getGraphicsComponent() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
