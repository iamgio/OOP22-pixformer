package pixformer.controller.input;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The standard implementation of an {@link ObservableInputPolling}.
 */
public class ObservableInputPollingImpl implements ObservableInputPolling {

    private final Set<InputType> inputs = new HashSet<>();
    private final Map<InputType, Set<Runnable>> onActionCallbacks = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(final InputType input) {
        this.inputs.add(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(final InputType input) {
        this.inputs.remove(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(final InputType input) {
        return this.inputs.contains(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAction(final InputType input, final Runnable action) {
        this.onActionCallbacks
                .computeIfAbsent(input, i -> new HashSet<>())
                .add(action);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        this.inputs.stream()
                .map(this.onActionCallbacks::get)
                .filter(Objects::nonNull)
                .forEach(callbacks -> callbacks.forEach(Runnable::run));
    }
}
