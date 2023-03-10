package pixformer.view;

import java.util.function.Consumer;

import pixformer.controller.input.ControllerInputComponent;
import pixformer.model.modelinput.ModelInput;

/**
 * It's an abstraction of command produced by a {@link pixformer.view.Command}
 * which will be collected by the controller.
 * 
 * @param <J> the joystick which will might receive the the command.
 */
public interface Command<J extends ModelInput> extends Consumer<ControllerInputComponent<J>> {

}
