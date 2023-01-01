package pixformer.view.javafx;

import javafx.scene.input.KeyCode;
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
    public void handleInput() {
        super.getScene().setOnKeyPressed(e -> this.getKeyboardInputMapper().map(e.getCode()).ifPresent(input -> getInputs().add(input)));
        super.getScene().setOnKeyReleased(e -> this.getKeyboardInputMapper().map(e.getCode()).ifPresent(input -> getInputs().remove(input)));
    }
}
