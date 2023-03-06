package pixformer.controller.input;

import pixformer.controller.GameLoopManager;

/**
 * It represents a controller which can pause and unpause the game.
 */
public class PauseControllerInput implements ControllerInput {

    /**
     * Constructor for the PauseController
     */
    public PauseControllerInput() {
    }

    /**
     * Pause/unpause the game.
     * 
     * @param gameLoopManager manager for the gameloop to control
     */
    @Override
    public void execute(final GameLoopManager gameLoopManager) {
        System.out.println(gameLoopManager.isRunning());
        if (!gameLoopManager.isRunning()) {
            gameLoopManager.resume();
        } else {
            gameLoopManager.pause();
        }
    }
}
