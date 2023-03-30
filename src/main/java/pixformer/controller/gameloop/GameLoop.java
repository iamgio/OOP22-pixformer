package pixformer.controller.gameloop;

/**
 * The game clock.
 */
public interface GameLoop {

    /**
     * Called at a fixed rate, and responsible for model updating and view
     * rendering.
     * 
     * @param dt current delta time in milliseconds
     */
    void loop(long dt);

}
