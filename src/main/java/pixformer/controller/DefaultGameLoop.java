package pixformer.controller;

import pixformer.view.View;

/**
 * The default game loop.
 */
public class DefaultGameLoop implements GameLoop {

    private final View view;

    /**
     * Creates the default game loop that relies on a visual renderable scene.
     * @param view active game view
     */
    public DefaultGameLoop(final View view) {
        this.view = view;
        this.view.setup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void loop(final long now) {
        this.view.update(0 /* TODO delta time */);
    }
}
