package pixformer.controller.level;

import pixformer.model.Level;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

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
     * @param playersAmount amount of players to play the level
     */
    void start(Level level, int playersAmount);

    /**
     * Adds a callback to call when a level is started.
     * @param action action to run when a level is started,
     *               with the new level and the amount of players as arguments
     */
    void addOnLevelStart(BiConsumer<Level, Integer> action);

    /**
     * Stops the ongoing level.
     * @throws java.lang.IllegalArgumentException if there isn't a currently active level
     */
    void endCurrentLevel();

    /**
     * Adds a callback to call when a level is stopped.
     * @param action action to run when a level is stopped, with the level and the leaderboard as args
     */
    void addOnLevelEnd(BiConsumer<Level, List<Integer>> action);
}
