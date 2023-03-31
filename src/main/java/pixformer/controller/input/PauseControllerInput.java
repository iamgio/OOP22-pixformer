package pixformer.controller.input;

import pixformer.controller.GameLoopManager;

/**
 * It represents a controller which can pause and unpause the game.
 */
public class PauseControllerInput {

    /**
     * Pause/unpause the game.
     * 
     * @param gameLoopManager manager for the gameloop to control
     */
    public void execute(final GameLoopManager gameLoopManager) {
        if (!gameLoopManager.isRunning()) {
            gameLoopManager.resume();
        } else {
            gameLoopManager.pause();
        }
    }
}
