package pixformer.common.wrap;

/**
 * The standard implementation of a read-only wrapper.
 *
 * @param <T> type of the wrapped value
 */
public class SimpleWrapper<T> implements Wrapper<T> {

    private final T value;

    /**
     * @param value wrapped value
     */
    public SimpleWrapper(final T value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get() {
        return this.value;
    }
}
