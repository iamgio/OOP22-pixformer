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
            case CONTROL -> level -> level.getPlayer1().ifPresent(CompleteModelInput::sprint);

            case LEFT -> level -> level.getPlayer2().ifPresent(CompleteModelInput::left);
            case RIGHT -> level -> level.getPlayer2().ifPresent(CompleteModelInput::right);
            case UP -> level -> level.getPlayer2().ifPresent(CompleteModelInput::jump);
            case M -> level -> level.getPlayer2().ifPresent(CompleteModelInput::ability);
            case N -> level -> level.getPlayer2().ifPresent(CompleteModelInput::sprint);

            case G -> level -> level.getPlayer3().ifPresent(CompleteModelInput::left);
            case J -> level -> level.getPlayer3().ifPresent(CompleteModelInput::right);
            case Y -> level -> level.getPlayer3().ifPresent(CompleteModelInput::jump);
            case C -> level -> level.getPlayer3().ifPresent(CompleteModelInput::ability);
            case X -> level -> level.getPlayer3().ifPresent(CompleteModelInput::sprint);

            case NUMPAD4 -> level -> level.getPlayer4().ifPresent(CompleteModelInput::left);
            case NUMPAD6 -> level -> level.getPlayer4().ifPresent(CompleteModelInput::right);
            case NUMPAD8 -> level -> level.getPlayer4().ifPresent(CompleteModelInput::jump);
            case NUMPAD2 -> level -> level.getPlayer4().ifPresent(CompleteModelInput::ability);
            case NUMPAD1 -> level -> level.getPlayer4().ifPresent(CompleteModelInput::sprint);

            default -> null;
        };
        return Optional.ofNullable(action);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Consumer<ControllerInput>> mapController(final KeyCode input) {
        final Consumer<ControllerInput> command = switch (input) {
            case P -> ControllerInput::pause;
            case O -> ControllerInput::resume;
            default -> null;
        };
        return Optional.ofNullable(command);
    }

}
