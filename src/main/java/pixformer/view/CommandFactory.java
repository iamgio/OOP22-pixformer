package pixformer.view;

import java.util.function.Consumer;

import pixformer.controller.input.ControllerInputComponent;
import pixformer.model.joystick.CompleteJoystick;

public class CommandFactory {

    private Command<CompleteJoystick> gameInput(Consumer<CompleteJoystick> input) {
        return new Command<CompleteJoystick>() {

            @Override
            public void accept(ControllerInputComponent<CompleteJoystick> arg0) {
                arg0.acceptGameInput(input);
            }
            
        };
        
    }

    public Command<CompleteJoystick> jump() {
        return gameInput(CompleteJoystick::jump);
    }

    public Command<CompleteJoystick> right() {
        return gameInput(CompleteJoystick::right);
    }
    
    public Command<CompleteJoystick> left() {
        return gameInput(CompleteJoystick::left);
    }

    public Command<CompleteJoystick> fire() {
        return gameInput(CompleteJoystick::fire);
    }

    public Command<CompleteJoystick> crouch() {
        return gameInput(CompleteJoystick::crouch);
    }

    public Command<CompleteJoystick> pause() {
        return ControllerInputComponent::pause;
    }

    public Command<CompleteJoystick> unpause() {
        return ControllerInputComponent::unpause;
    }
}
