package pixformer.controller;

import pixformer.model.Level;

import java.util.Optional;
import java.util.function.Consumer;

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
     * Adds a callback to call when a level is started.
     * @param action action to run when a level is started
     */
    void addOnLevelStart(Consumer<Level> action);

    /**
     * Stops the ongoing level.
     * @throws java.lang.IllegalArgumentException if there isn't a currently active level
     */
    void endCurrentLevel();

    /**
     * Adds a callback to call when a level is stopped.
     * @param action action to run when a level is stopped
     */
    void addOnLevelEnd(Consumer<Level> action);
}
