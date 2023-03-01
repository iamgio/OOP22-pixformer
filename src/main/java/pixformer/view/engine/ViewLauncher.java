package pixformer.view.engine;

import pixformer.controller.gameloop.GameLoop;

/**
 * Responsible for launching a kind of view.
 */
public interface ViewLauncher {

    /**
     * Launches the view.
     */
    void launch();

    /**
     * @return the active game scene
     */
    GameScene getScene();

    /**
     * Sets a new game scene as the active one.
     * @param scene new game scene
     */
    void setScene(GameScene scene);

    /**
     * @return the initial new game scene instance
     */
    GameScene createInitialScene();

    /**
     * @return a new game loop instance
     */
    GameLoop createGameLoop();

    /**
     * Starts the game loop.
     * @see ViewLauncher#createGameLoop()
     */
    void startGameLoop();
}
