package pixformer.controller;

import pixformer.controller.gameloop.GameLoop;
import pixformer.controller.level.LevelManager;
import pixformer.model.GameSettings;
import pixformer.model.Level;
import pixformer.model.entity.Entity;
import pixformer.view.View;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * The controller that acts as a bridge between model and view.
 */
public interface Controller {

    /**
     * Performs the actions required by the controller to work.
     */
    void setup();

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

    /**
     * @return level files on the filesystem
     */
    List<File> getLevelFiles();

    /**
     * Parses and extracts data from a level file
     * @param levelFile level file to parse
     * @return a new level instance loaded from the file
     * @throws IllegalStateException if the file could not be turned into a level
     */
    Level getLevelFromFile(File levelFile);
}
