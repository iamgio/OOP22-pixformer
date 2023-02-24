package pixformer.controller.input;

import pixformer.model.modelinput.CompleteModelInput;
import pixformer.model.modelinput.JumpModelInput;
import pixformer.model.modelinput.ModelInput;

/**
 * A bridge that makes view's interactions with the model easier
 *  by treating general {@link ModelInput}s as {@link CompleteModelInput}.
 */
public final class ModelInputViewBridge implements CompleteModelInput {

    private final ModelInput input;

    private ModelInputViewBridge(final ModelInput input) {
        this.input = input;
    }

    /**
     * Creates a bridge for a general {@link ModelInput}.
     * @param input model input to generalize
     * @return a new view-model bridge for the given model input
     */
    public static ModelInputViewBridge from(final ModelInput input) {
        return new ModelInputViewBridge(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void crouch() {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fire() {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void left() {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void right() {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void jump() {
        if (this.input instanceof JumpModelInput jumpable) {
            jumpable.jump();
        }
    }
}
