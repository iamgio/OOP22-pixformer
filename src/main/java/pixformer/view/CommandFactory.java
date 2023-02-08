package pixformer.view;

import java.util.function.Consumer;

import pixformer.controller.input.ControllerInputComponent;
import pixformer.model.joystick.CompleteJoystick;

/**
 * A factory for making the creation of Command easier.
 */
public final class CommandFactory {

    /**
     * Create a Command containing a call to a Joystick, in other words the Command
     * created will be solved inside the model.
     * 
     * @param input a call for a joystick
     * @return a new Command containing the call for a joystick inticated by
     *         {@code input}.
     */
    private Command<CompleteJoystick> gameInput(final Consumer<CompleteJoystick> input) {
        return new Command<CompleteJoystick>() {

            @Override
            public void accept(final ControllerInputComponent<CompleteJoystick> arg0) {
                arg0.acceptGameInput(input);
            }

        };

    }

    /**
     * @return command for jumping.
     */
    public Command<CompleteJoystick> jump() {
        return gameInput(CompleteJoystick::jump);
    }

    /**
     * @return command for going right.
     */
    public Command<CompleteJoystick> right() {
        return gameInput(CompleteJoystick::right);
    }

    /**
     * @return command for going left.
     */
    public Command<CompleteJoystick> left() {
        return gameInput(CompleteJoystick::left);
    }

    /**
     * @return command for firing.
     */
    public Command<CompleteJoystick> fire() {
        return gameInput(CompleteJoystick::fire);
    }

    /**
     * @return command for couching.
     */
    public Command<CompleteJoystick> crouch() {
        return gameInput(CompleteJoystick::crouch);
    }

    /**
     * @return command for pausing the game.
     */
    public Command<CompleteJoystick> pause() {
        return ControllerInputComponent::pause;
    }

    /**
     * @return command for unpausing the game.
     */
    public Command<CompleteJoystick> unpause() {
        return ControllerInputComponent::unpause;
    }
}
