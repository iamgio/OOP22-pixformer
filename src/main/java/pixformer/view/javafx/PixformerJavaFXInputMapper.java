package pixformer.view.javafx;

import javafx.scene.input.KeyCode;
import pixformer.controller.InputType;
import pixformer.view.engine.InputMapper;

import java.util.Map;

/**
 * Default input mapper for the game.
 */
public class PixformerJavaFXInputMapper extends InputMapper<KeyCode> {

    /**
     * Creates a default input mapper.
     */
    public PixformerJavaFXInputMapper() {
        // This could be deserialized in the future.
        super(Map.ofEntries(
                Map.entry(KeyCode.SPACE, InputType.P1_JUMP)
        ));
    }
}
