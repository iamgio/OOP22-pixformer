package pixformer.common;

/**
 * Generic 2D Vector
 * @param <T> type
 */
public interface Vector2D<T extends Number> {

    /**
     * Append a new Vector2D at the end of this Vector
     * @param v Vector2D to append
     */
    void add(Vector2D<T> v);

    /**
     * @return the X component
     */
    T getX();

    /**
     * @return the Y component
     */
    T getY();
}
