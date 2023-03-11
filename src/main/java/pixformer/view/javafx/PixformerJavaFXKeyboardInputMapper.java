package pixformer.view.javafx;

import javafx.scene.input.KeyCode;
import pixformer.controller.input.ControllerInput;
import pixformer.model.Level;
import pixformer.model.modelinput.CompleteModelInput;
import pixformer.view.engine.InputMapper;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Default input mapper for the game.
 */
public class PixformerJavaFXKeyboardInputMapper implements InputMapper<KeyCode> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Consumer<Level>> map(final KeyCode input) {
        final Consumer<Level> action = switch (input) {
            case A -> level -> level.getPlayer1().ifPresent(CompleteModelInput::left);
            case D -> level -> level.getPlayer1().ifPresent(CompleteModelInput::right);
            case SPACE -> level -> level.getPlayer1().ifPresent(CompleteModelInput::jump);
            case SHIFT -> level -> level.getPlayer1().ifPresent(CompleteModelInput::ability);
            case CONTROL -> level -> level.getPlayer1().ifPresent(CompleteModelInput::crouch);

            case W -> level -> level.getPlayer2().ifPresent(CompleteModelInput::jump);
            default -> null;
        };
        return Optional.ofNullable(action);
    }

    /**
     * @param input raw input
     * @return associated controller action, if it exists
     */
    public Optional<Consumer<ControllerInput>> mapController(final KeyCode input) {
        final Consumer<ControllerInput> command = switch (input) {
            case P -> controllerInput -> controllerInput.pause();
            case O -> controllerInput -> controllerInput.resume();
            default -> null;
        };
        return Optional.ofNullable(command);
    }

}
