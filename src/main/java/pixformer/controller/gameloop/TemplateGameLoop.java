package pixformer.controller.gameloop;


/**
 * A game loop with fixed operation to be performed. 
 */
public abstract class TemplateGameLoop implements GameLoop {

    private long previous;

    /**
     * When invoked, makes the game loop thread sleep for a certain amount of time.
     * 
     * @param dt the delta time between the previous iteration and the current one.
     */
    abstract void sleep(long dt);

    /**
     * When invoked the game loop processes the input of the user.
     */
    abstract void processInput();

    /**
     * Update the model.
     * @param dt dt the delta time between the previous iteration and the current one.
     */
    abstract void update(long dt);

    /**
     * Update the view.
     */
    abstract void render();

    @Override
    public final void loop(final long now) {
        final long elapsed = now - previous;
        processInput();
        update(elapsed);
        render();
        sleep(elapsed);
    }

}
