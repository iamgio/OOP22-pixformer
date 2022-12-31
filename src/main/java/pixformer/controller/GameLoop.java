package pixformer.controller;

/**
 * The game clock.
 */
public interface GameLoop {

    /**
     * Called at a fixed rate, and responsible for model updating and view rendering.
     * @param now current time in milliseconds
     */
    void loop(long now);
}
