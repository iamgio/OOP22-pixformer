package pixformer.view.javafx;

import javafx.scene.input.KeyCode;
import pixformer.controller.input.InputType;
import pixformer.view.engine.InputMapper;

import java.util.Optional;

/**
 * Default input mapper for the game.
 */
public class PixformerJavaFXKeyboardInputMapper implements InputMapper<KeyCode> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<InputType> map(final KeyCode input) {
        return Optional.ofNullable(
                switch (input) {
                    case SPACE -> InputType.P1_JUMP;
                    case P -> InputType.PAUSE;
                    default -> null;
                }
        );
    }
}
