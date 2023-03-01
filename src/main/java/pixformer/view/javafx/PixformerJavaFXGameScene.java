package pixformer.view.javafx;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import pixformer.view.engine.SceneInput;
import pixformer.view.engine.SceneInputImpl;
import pixformer.view.engine.javafx.JavaFXScene;

import java.util.Optional;

/**
 * The default game scene for JavaFX.
 */
public class PixformerJavaFXGameScene extends JavaFXScene {

    private static final double INITIAL_WIDTH = 1200;
    private static final double INITIAL_HEIGHT = 600;

    private final SceneInput<KeyCode> keyboardInput;
    private final SceneInput<MouseButton> mouseInput;

    /**
     * Initializes the default game scene.
     */
    public PixformerJavaFXGameScene() {
        super(INITIAL_WIDTH, INITIAL_HEIGHT);
        this.keyboardInput = new SceneInputImpl<>(new PixformerJavaFXKeyboardInputMapper());
        this.mouseInput = new SceneInputImpl<>(new PixformerJavaFXMouseInputMapper());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<SceneInput<KeyCode>> getKeyboardInput() {
        return Optional.of(this.keyboardInput);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<SceneInput<MouseButton>> getMouseInput() {
        return Optional.of(this.mouseInput);
    }
}
