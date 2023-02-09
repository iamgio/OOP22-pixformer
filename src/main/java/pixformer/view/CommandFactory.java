package pixformer.view;

import java.util.function.Consumer;

import pixformer.controller.input.ControllerInputComponent;
import pixformer.model.modelInput.CompleteModelInput;

/**
 * A factory for making the creation of Command easier.
 */
public final class CommandFactory {

    /**
     * Create a Command containing a call to a ModelInput, in other words the Command
     * created will be solved inside the model.
     * 
     * @param input a call for a joystick
     * @return a new Command containing the call for a joystick inticated by
     *         {@code input}.
     */
    private Command<CompleteModelInput> gameInput(final Consumer<CompleteModelInput> input) {
        return new Command<CompleteModelInput>() {

            @Override
            public void accept(final ControllerInputComponent<CompleteModelInput> arg0) {
                arg0.acceptGameInput(input);
            }

        };

    }

    /**
     * @return command for jumping.
     */
    public Command<CompleteModelInput> jump() {
        return gameInput(CompleteModelInput::jump);
    }

    /**
     * @return command for going right.
     */
    public Command<CompleteModelInput> right() {
        return gameInput(CompleteModelInput::right);
    }

    /**
     * @return command for going left.
     */
    public Command<CompleteModelInput> left() {
        return gameInput(CompleteModelInput::left);
    }

    /**
     * @return command for firing.
     */
    public Command<CompleteModelInput> fire() {
        return gameInput(CompleteModelInput::fire);
    }

    /**
     * @return command for couching.
     */
    public Command<CompleteModelInput> crouch() {
        return gameInput(CompleteModelInput::crouch);
    }

    /**
     * @return command for pausing the game.
     */
    public Command<CompleteModelInput> pause() {
        return ControllerInputComponent::pause;
    }

    /**
     * @return command for unpausing the game.
     */
    public Command<CompleteModelInput> unpause() {
        return ControllerInputComponent::unpause;
    }
}
