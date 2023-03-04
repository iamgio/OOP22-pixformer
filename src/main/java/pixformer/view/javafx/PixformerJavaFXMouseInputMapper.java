package pixformer.view.javafx;

import javafx.scene.input.MouseButton;
import pixformer.model.Level;
import pixformer.model.modelinput.CompleteModelInput;
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
    public Optional<Consumer<Level>> map(final MouseButton input) {
        final Consumer<Level> action = switch (input) {
            case PRIMARY -> level -> level.getPlayer1().ifPresent(CompleteModelInput::jump);
            default -> null;
        };
        return Optional.ofNullable(action);
    }
}
