package pixformer.common;

/**
 * An immutable two-dimensional vector.
 */
public interface Vector2D extends Point2D {

    /**
     * Sum of two vectors.
     * 
     * @param other
     * @return a new Vector2D whose components are the sum of the components of
     *         {@code this} and {@code other}.
     */
    Vector2D sum(Vector2D other);

    /**
     * Product between a vector and a scalar value.
     * 
     * @param k the scalar value
     * @return a new Vector2D whose components are the product of the components of
     *         {@code this} and {@code k}.
     */
    Vector2D scale(double k);

}
