package pixformer.controller.input;

import pixformer.controller.GameLoopManager;

/**
 * It represents a controller which can pause and unpause the game.
 */
public class PauseControllerInput implements ControllerInput {

    // private boolean isRunning;

    /**
     * Constructor for the PauseController
     */
    public PauseControllerInput() {
        // this.isRunning = true;
    }

    /**
     * Pause/unpause the game.
     * 
     * @param gameLoopManager manager for the gameloop to control
     */
    @Override
    public void execute(final GameLoopManager gameLoopManager) {
        // this.isRunning = !this.isRunning;
        if (!gameLoopManager.isRunning()) {
            gameLoopManager.start();
            System.out.println("Run");
        } else {
            gameLoopManager.stop();
            System.out.println("Stop");
        }
        System.out.println(gameLoopManager.isRunning());
    }
}
