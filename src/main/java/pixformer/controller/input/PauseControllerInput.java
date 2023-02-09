package pixformer.controller.input;

/**
 * It represents a controller which can pause and unpause the game.
 */
public interface PauseControllerInput extends ControllerInput {

    /**
     * Command for pausing the game.
     */
    void pause();

    /**
     * Command for unpausing the game.
     */
    void unpause();
}
