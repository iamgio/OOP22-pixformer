package pixformer.controller.input;

import pixformer.controller.Controller;

public class ControllerInputImpl implements ControllerInput {

    private final Controller controller;

    /**
     * Constructor for ControllerInput.
     * 
     * @param controller controller of the game
     */
    public ControllerInputImpl(final Controller controller) {
        this.controller = controller;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pause() {
        this.controller.getGameLoopManager().pause();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resume() {
        this.controller.getGameLoopManager().resume();
    }

}
