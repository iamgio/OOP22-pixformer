package pixformer.controller;

import pixformer.controller.gameloop.GameLoop;
import pixformer.model.GameSettings;
import pixformer.view.View;

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
     * Applies supported boundaries to a given amount of players.
     * @param playersAmount raw, unchecked, amount of players
     * @return the supported amount of players that matches the given value:
     *     the value itself if it matches the supported boundaries,
     *     or max/min if it is too low or too high
     */
    int correctSupportedPlayersAmount(int playersAmount);
}
