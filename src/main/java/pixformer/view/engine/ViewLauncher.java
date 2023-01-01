package pixformer.view.engine;

import pixformer.controller.GameLoop;

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
     * @return a new game scene instance
     */
    GameScene createScene();

    /**
     * @return a new game loop instance
     */
    GameLoop createGameLoop();
}
