package pixformer.controller;

import pixformer.controller.input.InputType;
import pixformer.controller.input.ObservableInputPolling;
import pixformer.model.Player;
import pixformer.model.World;
import pixformer.view.View;

/**
 * The default game loop.
 */
public class DefaultGameLoop implements GameLoop {

    private final World world;
    private final View view;

    /**
     * Creates the default game loop that relies on a visual renderable scene.
     * @param world active game world
     * @param view active game view
     */
    public DefaultGameLoop(final World world, final View view) {
        this.world = world;
        this.view = view;
        this.view.setup();
        this.setupInputHooks();
    }

    /**
     * Translates raw input to actions.
     */
    private void setupInputHooks() {
        final ObservableInputPolling input = this.view.getInputPolling();
        input.addAction(InputType.P1_JUMP, () -> this.world.getPlayer1().ifPresent(Player::jump));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void loop(final long now) {
        this.view.update(0 /* TODO delta time */);
    }
}
