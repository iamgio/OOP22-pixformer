package pixformer.common;

/**
 * An immutable two-dimensional vector.
 */
public interface Vector2D extends Point2D {

    /**
     * @param point
     * @return a new Vector2D whose components are the same of {@code point}.
     */
    static Vector2D fromPoint(final Point2D point) {
        return new Vector2D() {

            @Override
            public double getX() {
                return point.getX();
            }

            @Override
            public double getY() {
                return point.getY();
            }

        };
    }

    /**
     * @param x
     * @param y
     * @return a new Vector2D of components {@code x} and {@code y}.
     */
    static Vector2D of(final double x, final double y) {
        return fromPoint(Point2D.of(x, y));
    }

    /**
     * Sum of two vectors.
     * 
     * @param other
     * @return a new Vector2D whose components are the sum of the components of
     *         {@code this} and {@code other}.
     */
    default Vector2D sum(final Vector2D other) {
        return of(this.getX() + other.getX(), this.getY() + other.getY());
    }

    /**
     * Product between a vector and a scalar value.
     * 
     * @param k the scalar value
     * @return a new Vector2D whose components are the product of the components of
     *         {@code this} and {@code k}.
     */
    default Vector2D scale(final double k) {
        return of(this.getX() * k, this.getY() * k);
    }

}
