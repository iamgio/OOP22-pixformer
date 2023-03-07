package pixformer.common.wrap;

/**
 * A generic wrapper for a read-only, non-modifiable value.
 * A common scenario where this is useful would be
 * protecting a field from external modifications.
 *
 * @param <T> type of the wrapped value
 */
public interface Wrapper<T> {

    /**
     * @return the wrapped value
     */
    T get();
}
