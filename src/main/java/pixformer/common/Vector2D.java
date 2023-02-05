package pixformer.common;

/**
 * Double 2D Vector.
 */
public interface Vector2D extends Point2D {

    /**
     * Append a new Vector2D at the end of this Vector.
     * @param v Vector2D to append
     */
    void add(Vector2D v);

}
