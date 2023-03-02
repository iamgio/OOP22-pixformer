package pixformer.controller;

import pixformer.controller.gameloop.GameLoop;
import pixformer.model.GameSettings;
import pixformer.view.ViewImpl;

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
     * @param view view to output to
     * @return a new game loop instance
     */
    GameLoop createGameLoop(ViewImpl view); // TODO change to View

    /**
     * Starts running the current game loop.
     */
    void startGameLoop();
}
