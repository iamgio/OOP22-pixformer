package pixformer.common;

/**
 * An immutable two-dimensional vector.
 *
 * @param x X component
 * @param y Y component
 */
public record Vector2D(double x, double y) {

    /**
     * Sums two vectors.
     * @param vector2d vector to add
     * @return a new Vector2D whose components are the sum of the components of
     * {@code this} and {@code other}.
     */
    public Vector2D sum(final Vector2D vector2d) {
        return new Vector2D(this.x + vector2d.x, this.y + vector2d.y);
    }

    /**
     * Multiplies a vector by a scalar value.
     * @param k the scalar value
     * @return a new Vector2D whose components are the product of the components of
     * {@code this} and {@code k}.
     */
    public Vector2D scale(final double k) {
        return new Vector2D(this.x * k, this.y * k);
    }

    /**
     * Create a new vector with the same X coordinate but a different Y coordinate.
     * @param y new Y coordinate
     * @return a new Vector with a new Y coordinate
     */
    public Vector2D copyWithY(final double y) {
        return new Vector2D(this.x, y);
    }

    /**
     * Create a new vector with the same Y coordinate but a different X coordinate.
     * @param x new X coordinate
     * @return a new Vector with a new X coordinate
     */
    public Vector2D copyWithX(final double x) {
        return new Vector2D(x, this.y);
    }
}
