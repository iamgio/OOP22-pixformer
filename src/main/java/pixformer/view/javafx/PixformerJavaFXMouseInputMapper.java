package pixformer.view.javafx;

import javafx.scene.input.MouseButton;
import pixformer.controller.input.ModelInputViewBridge;
import pixformer.model.modelinput.ModelInput;
import pixformer.view.engine.InputMapper;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Default input mapper for the game.
 */
public class PixformerJavaFXMouseInputMapper implements InputMapper<MouseButton> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Consumer<ModelInput>> map(final MouseButton input) {
        final Consumer<ModelInput> action = switch (input) {
            case PRIMARY -> model -> ModelInputViewBridge.from(model).jump();
            default -> null;
        };
        return Optional.ofNullable(action);
    }
}
