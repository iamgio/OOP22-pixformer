package pixformer.model.entity;

import pixformer.common.Vector2D;

/**
 * An {@link Entity} whose state, position and dimension can be modified.
 */
public interface MutableEntity extends Entity {

    /**
     * Set the X coordinate of the entity.
     *
     * @param x the new X coordinate
     */
    void setX(double x);

    /**
     * Set the Y coordinate of the entity.
     *
     * @param y the new Y coordinate
     */
    void setY(double y);

    /**
     * Set the width of the entity.
     *
     * @param width the new width
     */
    void setWidth(double width);

    /**
     * Set the height of the entity.
     *
     * @param height the new height
     */
    void setHeight(double height);

    /**
     * Set the new velocity of the entity.
     *
     * @param velocity the new velocity
     */
    void setVelocity(Vector2D velocity);

    /**
     * {@inheritDoc}
     */
    @Override
    default void update(final double dt) {
        setX(getX() + dt * getVelocity().x());
        setY(getY() + dt * getVelocity().y());
    }
}
