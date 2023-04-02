package pixformer.controller.level;

import pixformer.model.Level;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;

/**
 * Implementation of a {@link LevelManager}.
 */
public class LevelManagerImpl implements LevelManager {

    private final List<BiConsumer<Level, Integer>> onStart = new LinkedList<>();
    private final List<BiConsumer<Level, List<Integer>>> onEnd = new LinkedList<>();

    private Level level;

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
    public void start(final Level level, final int playersAmount) {
        this.level = Objects.requireNonNull(level);
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
        final Level level = this.level;

        if (level == null) {
            throw new IllegalStateException("No level to end.");
        }

        this.onEnd.forEach(action -> action.accept(level, level.getWorld().getIndexLeaderboard()));
        this.level = null;
    }

    /**
     * {@inheritDoc}
     * @implNote newly added actions have higher priority
     */
    @Override
    public void addOnLevelEnd(final BiConsumer<Level, List<Integer>> action) {
        this.onEnd.add(0, action);
    }
}
