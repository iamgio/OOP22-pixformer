package pixformer.view.javafx;

import javafx.scene.input.KeyCode;
import pixformer.controller.input.ControllerInput;
import pixformer.controller.input.ModelInputViewBridge;
import pixformer.controller.input.PauseControllerInput;
import pixformer.model.modelinput.ModelInput;
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
    public Optional<Consumer<ModelInput>> map(final KeyCode input) {
        final Consumer<ModelInput> action = switch (input) {
            case SPACE -> model -> ModelInputViewBridge.from(model).jump();
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
