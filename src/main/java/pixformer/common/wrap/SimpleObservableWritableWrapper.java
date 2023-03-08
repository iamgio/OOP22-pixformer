package pixformer.common.wrap;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * The standard implementation of a modifiable observable wrapper.
 *
 * @param <T> type of the wrapped value
 */
public class SimpleObservableWritableWrapper<T> extends SimpleWritableWrapper<T> implements ObservableWritableWrapper<T> {

    private final Set<Consumer<T>> onChange = new HashSet<>();

    /**
     * @param value the initial wrapped value
     */
    public SimpleObservableWritableWrapper(final T value) {
        super(value);
    }

    /**
     * Instantiates the wrapped value to its default initial value, commonly <tt>null</tt>.
     */
    public SimpleObservableWritableWrapper() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void set(final T value) {
        super.set(value);
        this.onChange.forEach(action -> action.accept(value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOnChange(final Consumer<T> onChange) {
        this.onChange.add(onChange);
    }
}
