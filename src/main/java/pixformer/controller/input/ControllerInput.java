package pixformer.controller.input;

import pixformer.controller.GameLoopManager;

/**
 * A tagging interface for the interfaces whose methods represent commands to
 * the controller.
 */
public interface ControllerInput {

    /**
     * Execute a specific action.
     * 
     * @param gameLoopManager gameloop to apply the action on
     */
    void execute(GameLoopManager gameLoopManager);

}
