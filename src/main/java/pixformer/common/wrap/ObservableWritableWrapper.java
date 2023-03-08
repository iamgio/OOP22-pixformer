package pixformer.common.wrap;

import java.util.function.Consumer;

/**
 * A generic wrapper for modifiable observable values.
 *
 * @param <T> type of the wrapped value
 */
public interface ObservableWritableWrapper<T> extends WritableWrapper<T> {

    /**
     * Adds a callback to be called when the wrapped value is updated.
     * @param onChange action to execute
     */
    void addOnChange(Consumer<T> onChange);
}
