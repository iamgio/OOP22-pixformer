package pixformer.view.javafx;

import javafx.scene.input.KeyCode;
import pixformer.controller.input.ControllerInput;
import pixformer.controller.input.ModelInputViewBridge;
import pixformer.controller.input.PauseControllerInput;
import pixformer.model.Level;
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
            case SPACE -> level -> ModelInputViewBridge.from(level.getPlayerEntityInputComponents().get(0)).jump();
            case W -> level -> ModelInputViewBridge.from(level.getPlayerEntityInputComponents().get(1)).jump();
            default -> null;
        };
        return Optional.ofNullable(action);
    }

    /**
     * @param input raw input
     * @return associated controller action, if it exists
     */
    public Optional<ControllerInput> mapController(final KeyCode input) {
        final ControllerInput command = switch (input) {
            case P -> new PauseControllerInput();
            default -> null;
        };
        return Optional.ofNullable(command);
    }

}
