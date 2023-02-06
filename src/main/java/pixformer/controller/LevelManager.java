package pixformer.controller;

import pixformer.model.Level;

import java.util.Optional;

/**
 * Handler of playable levels.
 */
public interface LevelManager {

    /**
     * @return the level that is being played, if it exists
     */
    Optional<Level> getCurrentLevel();

    /**
     * Starts a new level, and updates the current level.
     * @param level new level to start
     */
    void start(Level level);

    /**
     * Stops an ongoing level.
     * @param level level to end
     * @throws java.lang.IllegalArgumentException if the given level isn't active and/or cannot be stopped
     */
    void end(Level level);
}
