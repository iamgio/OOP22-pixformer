package pixformer.controller;

/**
 * The game clock.
 */
public interface GameLoop {

    /**
     * Called at a fixed rate, and responsible for model updating and view rendering.
     */
    void loop();
}
