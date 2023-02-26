package pixformer.model.entity;

import pixformer.common.Vector2D;

/**
 * Abstract class for a drawable entity.
 */
public class AbstractDrawableEntity implements DrawableEntity { 

    /**
     * Current moving direction of the entity.
     */
    public enum Direction {
        /**
         * Entity is going left.
         */
        LEFT,
        /**
         * Entity is going right.
         */
        RIGHT
    }

    //Current entity direction.
    protected Direction direction;

    //Current entity position.
    protected Vector2D position;

    //Current entity sizes.
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
        this.position = new Vector2D(x, y);
        this.width = width;
        this.height = height;
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
     * 
     * @return Current entity moving direction.
     */
    public Direction getDirection(){
        return this.direction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
