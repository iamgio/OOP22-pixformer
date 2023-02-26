package pixformer.view.engine;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The default implementation of an input source.
 *
 * @param <T> raw input type
 */
public class SceneInputImpl<T> implements SceneInput<T> {

    private final Set<T> polling = new HashSet<>();
    private final InputMapper<T> mapper;

    /**
     * @param mapper mapper from raw inputs to actions
     */
    public SceneInputImpl(final InputMapper<T> mapper) {
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addInput(final T input) {
        this.polling.add(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeInput(final T input) {
        this.polling.remove(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<T> getRawPolling() {
        return Collections.unmodifiableSet(this.polling);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InputMapper<T> getMapper() {
        return this.mapper;
    }
}
