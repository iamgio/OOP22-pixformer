package pixformer.controller.input;

/**
 * A tagging interface for the interfaces whose methods represent commands to
 * the controller.
 */
public interface ControllerInput {

    /**
     * Pause the game.
     */
    void pause();

    /**
     * Resume the game.
     */
    void resume();

}
