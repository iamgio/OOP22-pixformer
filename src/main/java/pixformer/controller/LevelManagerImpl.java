package pixformer.controller;

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

    private Level level;

    private final Set<Consumer<Level>> onStart = new HashSet<>();
    private final Set<Consumer<Level>> onEnd = new HashSet<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Level> getCurrentLevel() {
        return Optional.ofNullable(this.level);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final Level level) {
        this.level = Objects.requireNonNull(level);
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
        if (this.level == null) {
            throw new IllegalStateException("No level to end.");
        }

        this.onEnd.forEach(action -> action.accept(this.level));
        this.level = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOnLevelEnd(final Consumer<Level> action) {
        this.onEnd.add(action);
    }
}
