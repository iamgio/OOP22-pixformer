package pixformer.view.engine.javafx;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import pixformer.controller.input.ObservableInputPolling;
import pixformer.controller.input.ObservableInputPollingImpl;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.Graphics;
import pixformer.view.engine.InputMapper;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.SceneRenderer;

import java.util.Optional;

/**
 * A JavaFX scene of the game.
 */
public class JavaFXScene extends GameScene {

    private final Scene scene;
    private final SceneRenderer renderer;
    private final Graphics graphics;
    private final RendererFactory rendererFactory;
    private final ObservableInputPolling inputPolling;

    /**
     * Creates a JavaFX {@link Canvas}-based game scene.
     * @param width initial scene width
     * @param height initial scene height
     */
    public JavaFXScene(final double width, final double height) {
        Canvas canvas = new Canvas();
        AnchorPane root = new AnchorPane(canvas);
        canvas.setWidth(width);
        canvas.setHeight(height);

        this.scene = new Scene(root);
        this.renderer = new SceneRenderer();
        this.graphics = new JavaFXGraphics(canvas.getGraphicsContext2D());
        this.rendererFactory = new JavaFXRendererFactory();
        this.inputPolling = new ObservableInputPollingImpl();

        // Makes the canvas resizable by resizing the window

        root.widthProperty().addListener(o -> {
            graphics.clear();
            canvas.setWidth(root.getWidth());
            this.render();
        });

        root.heightProperty().addListener(o -> {
            graphics.clear();
            canvas.setHeight(root.getHeight());
            this.render();
        });

        // Implementation-specific
        this.handleInput();
    }

    /**
     * @return the wrapped JavaFX scene
     */
    public Scene getScene() {
        return this.scene;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SceneRenderer getRenderer() {
        return this.renderer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Graphics getGraphics() {
        return this.graphics;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RendererFactory getRendererFactory() {
        return this.rendererFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObservableInputPolling getInputPolling() {
        return this.inputPolling;
    }

    /**
     * Implementation-specific input mapping, empty by default.
     * {@inheritDoc}
     */
    @Override
    protected InputMapper<KeyCode> getKeyboardInputMapper() {
        return input -> Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected InputMapper<MouseButton> getMouseInputMapper() {
        return input -> Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleInput() {
        // Keyboard
        this.scene.setOnKeyPressed(e -> this.getKeyboardInputMapper().map(e.getCode()).ifPresent(inputPolling::add));
        this.scene.setOnKeyReleased(e -> this.getKeyboardInputMapper().map(e.getCode()).ifPresent(inputPolling::remove));
        // Mouse
        this.scene.setOnMousePressed(e -> this.getMouseInputMapper().map(e.getButton()).ifPresent(inputPolling::add));
        this.scene.setOnMouseReleased(e -> this.getMouseInputMapper().map(e.getButton()).ifPresent(inputPolling::remove));
    }
}
