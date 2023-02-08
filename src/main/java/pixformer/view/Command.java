package pixformer.view;

import java.util.function.Consumer;

import pixformer.controller.input.ControllerInputComponent;
import pixformer.model.joystick.Joystick;

public interface Command<J extends Joystick> extends Consumer<ControllerInputComponent<J>> {
    
}
