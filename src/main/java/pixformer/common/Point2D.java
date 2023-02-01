package pixformer.common;

/**
 * Generic 2D point
 * @param <T> type
 */
public interface Point2D<T extends Number> {

    /**
     * @return the X component
     */
    T getX();

    /**
     * @return the Y component
     */
    T getY();

}
