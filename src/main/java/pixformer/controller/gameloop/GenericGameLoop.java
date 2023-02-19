package pixformer.controller.gameloop;

import java.util.function.LongConsumer;

/**
 * Strategy pattern solution for creating a game loop.
 */
public class GenericGameLoop implements GameLoop {

    private long previous;
    private boolean isFirstIteration = true;
    private final Runnable processInput;
    private final LongConsumer update;
    private final Runnable render;
    private final LongConsumer sleep;

    /**
     * Construct a new GenericGameLoop.
     * @param processInput the action to be performed to collect inputs
     * @param update the action for updating the model
     * @param render the action for updating the view
     * @param sleep the action which can make the game loop thread sleep.
     */
    public GenericGameLoop(
        final Runnable processInput,
        final LongConsumer update,
        final Runnable render,
        final LongConsumer sleep
    ) {
        this.processInput = processInput;
        this.update = update;
        this.render = render;
        this.sleep = sleep;
    }

    private void loopRoutine(final long elapsed) {
        processInput.run();
        update.accept(elapsed);
        render.run();
        sleep.accept(elapsed);
    }

    @Override
    public final void loop(final long now) {
        final long elapsed = isFirstIteration ? 0 : now - previous;
        loopRoutine(elapsed);
        isFirstIteration = false;
        previous = now;
    }
}
