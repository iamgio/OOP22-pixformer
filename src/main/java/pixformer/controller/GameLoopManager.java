package pixformer.controller;

/**
 * Handler for multiple, sequential, game loops.
 */
public interface GameLoopManager {

    /**
     * Starts a new game loop.
     */
    void start();

    /**
     * Ends the current game loop.
     */
    void stop();
}
