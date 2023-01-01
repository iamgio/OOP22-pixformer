package pixformer.view.javafx;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import pixformer.view.engine.InputMapper;
import pixformer.view.engine.javafx.JavaFXScene;

/**
 * The default game scene for JavaFX.
 */
public class PixformerJavaFXScene extends JavaFXScene {

    private static final double INITIAL_WIDTH = 1200;
    private static final double INITIAL_HEIGHT = 600;

    public PixformerJavaFXScene() {
        super(INITIAL_WIDTH, INITIAL_HEIGHT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected InputMapper<KeyCode> getKeyboardInputMapper() {
        return new PixformerJavaFXKeyboardInputMapper();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected InputMapper<MouseButton> getMouseInputMapper() {
        return new PixformerJavaFXMouseInputMapper();
    }
}
