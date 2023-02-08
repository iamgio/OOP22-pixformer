package pixformer.model;

import java.util.function.Consumer;

import pixformer.model.joystick.CompleteJoystick;

/**
 * An interface responsible of accepting input for the model.
 * For each controllable entity in the game there should be one instance of this
 * interface.
 */
public interface ModelInputComponent {

    /**
     * Accept an input for a controllable entity in the game.
     * 
     * @param input a call to a joystick indicating the action which shall be
     *              performed by the entity.
     */
    void acceptMarioInput(Consumer<CompleteJoystick> input);
}
