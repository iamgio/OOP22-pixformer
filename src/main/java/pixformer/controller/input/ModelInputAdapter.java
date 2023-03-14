package pixformer.controller.input;

import pixformer.model.modelinput.AbilityModelInput;
import pixformer.model.modelinput.CompleteModelInput;
import pixformer.model.modelinput.CrouchModelInput;
import pixformer.model.modelinput.HorizontalModelInput;
import pixformer.model.modelinput.JumpModelInput;
import pixformer.model.modelinput.ModelInput;

/**
 * A bridge that makes view's interactions with the model easier
 *  by treating general {@link ModelInput}s as {@link CompleteModelInput}s.
 */
public final class ModelInputAdapter implements CompleteModelInput {

    private final ModelInput input;

    private ModelInputAdapter(final ModelInput input) {
        this.input = input;
    }

    /**
     * Creates a bridge for a general {@link ModelInput}.
     * @param input model input to generalize
     * @return a new view-model bridge for the given model input
     */
    public static ModelInputAdapter from(final ModelInput input) {
        return new ModelInputAdapter(input);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void crouch() {
        if (this.input instanceof CrouchModelInput crouchable) {
            crouchable.crouch();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void ability() {
        if (this.input instanceof AbilityModelInput activable) {
            activable.ability();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void left() {
        if (this.input instanceof HorizontalModelInput movable) {
            movable.left();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void right() {
        if (this.input instanceof HorizontalModelInput movable) {
            movable.right();
        }
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
