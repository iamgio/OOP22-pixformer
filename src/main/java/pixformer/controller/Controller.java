package pixformer.controller;

import pixformer.controller.gameloop.GameLoop;
import pixformer.model.GameSettings;
import pixformer.model.Level;
import pixformer.model.entity.Entity;
import pixformer.view.View;

import java.util.Set;

/**
 * The controller that acts as a bridge between model and view.
 */
public interface Controller {

    /**
     * @return current game mechanics settings
     */
    GameSettings getSettings();

    /**
     * @return the handler for playable levels
     */
    LevelManager getLevelManager();

    /**
     * @return the handler for game loop cycles
     */
    GameLoopManager getGameLoopManager();

    /**
     * @param view view to output to
     * @return a new game loop instance
     */
    GameLoop createGameLoop(View view); // TODO change to View

    /**
     * Set-ups, initializes and starts the given level with a given amount of players.
     * @param level level to start
     * @param playersAmount amount of players to play the level
     * @implNote this is designed to be a consequence of {@link LevelManager#start(Level, int)},
     *     so the implementation should not call that method.
     */
    void initLevel(Level level, int playersAmount);

    /**
     * Stops the lifecycle of the given level.
     * @param level level to start
     * @implNote this is designed to be a consequence of {@link LevelManager#endCurrentLevel()},
     *     so the implementation should not call that method.
     */
    void stopLevel(Level level);

    /**
     * Applies supported boundaries to a given amount of players.
     * @param playersAmount raw, unchecked, amount of players
     * @return the supported amount of players that matches the given value:
     *     the value itself if it matches the supported boundaries,
     *     or max/min if it is too low or too high
     */
    int correctSupportedPlayersAmount(int playersAmount);

    /**
     * @param entities entities to find a common point for
     * @return X coordinate of the common point (possibly average) between the given entitites
     */
    double calcEntitiesCommonPointX(Set<Entity> entities);
}
