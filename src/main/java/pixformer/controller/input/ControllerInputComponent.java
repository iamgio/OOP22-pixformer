package pixformer.controller.input;

import java.util.function.Consumer;

import pixformer.model.joystick.Joystick;

public interface ControllerInputComponent<J extends Joystick> {

    void acceptGameInput(Consumer<J> input);

    void pause();

    void unpause();
}
