package pixformer.common.wrap;

/**
 * The standard implementation of a modifiable wrapper.
 *
 * @param <T> type of the wrapped value
 */
public class SimpleWritableWrapper<T> implements WritableWrapper<T> {

    private T value;

    /**
     * @param value the initial wrapped value
     */
    public SimpleWritableWrapper(final T value) {
        this.value = value;
    }

    /**
     * Instantiates the wrapped value to its default initial value, commonly <tt>null</tt>.
     */
    public SimpleWritableWrapper() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get() {
        return this.value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void set(final T value) {
        this.value = value;
    }
}
