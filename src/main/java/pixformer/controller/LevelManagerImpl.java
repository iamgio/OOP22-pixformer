package pixformer.controller;

import pixformer.common.wrap.SimpleWritableWrapper;
import pixformer.common.wrap.WritableWrapper;
import pixformer.model.Level;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Implementation of a {@link LevelManager}.
 */
public class LevelManagerImpl implements LevelManager {

    private final WritableWrapper<Level> level = new SimpleWritableWrapper<>();

    private final Set<Consumer<Level>> onStart = new HashSet<>();
    private final Set<Consumer<Level>> onEnd = new HashSet<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Level> getCurrentLevel() {
        return Optional.ofNullable(this.level.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final Level level) {
        this.level.set(Objects.requireNonNull(level));
        this.onStart.forEach(action -> action.accept(level));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOnLevelStart(final Consumer<Level> action) {
        this.onStart.add(action);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endCurrentLevel() {
        final Level level = this.level.get();

        if (level == null) {
            throw new IllegalStateException("No level to end.");
        }

        this.onEnd.forEach(action -> action.accept(level));
        this.level.set(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOnLevelEnd(final Consumer<Level> action) {
        this.onEnd.add(action);
    }
}
