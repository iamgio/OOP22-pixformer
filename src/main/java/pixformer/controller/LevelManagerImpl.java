package pixformer.controller;

import pixformer.common.wrap.SimpleWritableWrapper;
import pixformer.common.wrap.WritableWrapper;
import pixformer.model.Level;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Implementation of a {@link LevelManager}.
 */
public class LevelManagerImpl implements LevelManager {

    private final WritableWrapper<Level> level = new SimpleWritableWrapper<>();

    private final List<BiConsumer<Level, Integer>> onStart = new LinkedList<>();
    private final List<Consumer<Level>> onEnd = new LinkedList<>();

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
    public void start(final Level level, final int playersAmount) {
        this.level.set(Objects.requireNonNull(level));
        this.onStart.forEach(action -> action.accept(level, playersAmount));
    }

    /**
     * {@inheritDoc}
     * @implNote newly added actions have higher priority
     */
    @Override
    public void addOnLevelStart(final BiConsumer<Level, Integer> action) {
        this.onStart.add(0, action);
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
     * @implNote newly added actions have higher priority
     */
    @Override
    public void addOnLevelEnd(final Consumer<Level> action) {
        this.onEnd.add(0, action);
    }
}
