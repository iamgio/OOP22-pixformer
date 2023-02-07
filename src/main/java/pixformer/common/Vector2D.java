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
     * @param other vector to add
     * @return a new Vector2D whose components are the sum of the components of
     * {@code this} and {@code other}.
     */
    public Vector2D sum(final Vector2D other) {
        return new Vector2D(this.x + other.x, this.y + other.y);
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
}
