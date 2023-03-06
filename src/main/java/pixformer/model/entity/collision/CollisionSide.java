package pixformer.model.entity.collision;

/**
 * The side a collision can occur at.
 */
public enum CollisionSide {

    /**
     * Collision at the top.
     */
    TOP,

    /**
     * Collision at the bottom.
     */
    BOTTOM,

    /**
     * Collision on the left.
     */
    LEFT,

    /**
     * Collision on the right.
     */
    RIGHT;

    /**
     * @return whether the collision side is on the vertical axis
     */
    public boolean isVertical() {
        return this == TOP || this == BOTTOM;
    }

    /**
     * @return whether the collision side is on the horizontal axis
     */
    public boolean isHorizontal() {
        return this == LEFT || this == RIGHT;
    }
}
