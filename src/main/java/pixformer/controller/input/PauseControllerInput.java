package pixformer.controller.input;

/**
 * It represents a controller which can pause and unpause the game.
 */
public class PauseControllerInput implements ControllerInput {

    private boolean isRunning;

    /**
     * Constructor for the PauseController
     */
    public PauseControllerInput() {
        this.isRunning = true;
    }

    /**
     * Pause the game.
     */
    @Override
    public void execute() {
        this.isRunning = !isRunning;
    }
}
