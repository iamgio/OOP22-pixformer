package pixformer.controller;

import pixformer.model.Level;

import java.util.Objects;
import java.util.Optional;

/**
 * Implementation of a {@link LevelManager}.
 */
public class LevelManagerImpl implements LevelManager {

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
    public void start(final Level level) {
        this.level = Objects.requireNonNull(level);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void end(final Level level) {
        // TODO check if the level can be stopped, throw exception otherwise
        this.level = null;
    }
}
