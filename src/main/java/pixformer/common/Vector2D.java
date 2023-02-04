package pixformer.common;

/**
 * Double 2D Vector.
 */
public interface Vector2D {

    /**
     * Append a new Vector2D at the end of this Vector.
     * @param v Vector2D to append
     */
    void add(Vector2D v);

    /**
     * @return the X component
     */
    double getX();

    /**
     * @return the Y component
     */
    double getY();
}
