package pixformer.controller;

import pixformer.model.GameSettings;

/**
 * The controller that acts as a bridge between model and view.
 */
public interface Controller {

    /**
     * @return the core loop of the game
     */
    GameLoop getGameLoop();

    /**
     * @return current game mechanics settings
     */
    GameSettings getSettings();

    /**
     * @return the handler for playable levels
     */
    LevelManager getLevelManager();
}
