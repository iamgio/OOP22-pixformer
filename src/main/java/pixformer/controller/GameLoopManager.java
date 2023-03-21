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

    /**
     * @return if the game loop is running
     */
    boolean isRunning();

    /**
     * Pause the game loop.
     */
    void pause();

    /**
     * Unpause the game loop.
     */
    void resume();
}
