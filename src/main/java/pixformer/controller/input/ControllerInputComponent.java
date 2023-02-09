package pixformer.controller.input;

import java.util.function.Consumer;

import pixformer.model.modelInput.ModelInput;

/**
 * An interface which represents a component of the controller which will
 * accepts calls from a {@link pixformer.view.viewInputComponent}.
 * 
 * @param <J> the ModelInput type which this class will accept calls.
 */
public interface ControllerInputComponent<J extends ModelInput> {

    /**
     * Accept an input related to game actions.
     * 
     * @param input a call to the joystick connected to this
     *              {@code ControllerInputComponent} object.
     */
    void acceptGameInput(Consumer<J> input);

    /**
     * pause the game.
     */
    void pause();

    /**
     * Unpause the game.
     */
    void unpause();
}
