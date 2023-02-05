package pixformer.view.javafx;

import javafx.scene.input.MouseButton;
import pixformer.controller.input.InputType;
import pixformer.view.engine.InputMapper;

import java.util.Optional;

/**
 * Default input mapper for the game.
 */
public class PixformerJavaFXMouseInputMapper implements InputMapper<MouseButton> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<InputType> map(final MouseButton input) {
        return Optional.ofNullable(
                switch (input) {
                    case PRIMARY -> InputType.P1_JUMP;
                    default -> null;
                }
        );
    }
}
