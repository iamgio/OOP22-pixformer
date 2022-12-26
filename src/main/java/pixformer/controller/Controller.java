package pixformer.controller;

/**
 * The controller that acts as a bridge between model and view.
 */
public interface Controller {

    /**
     * @return the core loop of the game
     */
    GameLoop getGameLoop();

    /**
     * @return the handler for playable levels
     */
    LevelManager getLevelManager();
}
