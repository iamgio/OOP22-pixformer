package pixformer.controller;

import pixformer.controller.gameloop.GameLoop;
import pixformer.model.GameSettings;

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
     * @return the core loop of the game
     */
    GameLoop getGameLoop();

    /**
     * Sets the current game loop.
     * @param gameLoop new game loop
     */
    void setGameLoop(GameLoop gameLoop);
}
