package pixformer.view.javafx;

import javafx.scene.input.KeyCode;
import pixformer.common.Either;
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

    Either<Consumer<ModelInput>, Consumer<PauseControllerInput>> a = null;

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

    // public Either<Consumer<ModelInput>, Consumer<PauseControllerInput>> map(final
    // KeyCode input) {
    // return null;
    // }

}
