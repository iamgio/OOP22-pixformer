package pixformer.common.wrap;

/**
 * A generic wrapper for modifiable values.
 * A common scenario where this is useful would be
 * protecting a field from external modifications.
 *
 * @param <T> type of the wrapped value
 */
public interface WritableWrapper<T> extends Wrapper<T> {

    /**
     * Sets a new value.
     * @param value new value
     */
    void set(T value);
}
