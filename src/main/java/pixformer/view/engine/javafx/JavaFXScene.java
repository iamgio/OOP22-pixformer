package pixformer.view.engine.javafx;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.Graphics;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.SceneInput;
import pixformer.view.engine.SceneRenderer;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A JavaFX scene of the game.
 */
public class JavaFXScene extends GameScene {

    private final Scene scene;
    private final SceneRenderer renderer;
    private final Graphics graphics;
    private final RendererFactory rendererFactory;

    /**
     * Creates a JavaFX {@link Canvas}-based game scene.
     * @param width initial scene width
     * @param height initial scene height
     */
    public JavaFXScene(final double width, final double height) {
        final Canvas canvas = new Canvas();
        final AnchorPane root = new AnchorPane(canvas);
        canvas.setWidth(width);
        canvas.setHeight(height);

        this.scene = new Scene(root);
        this.renderer = new SceneRenderer();
        this.graphics = new JavaFXGraphics(canvas.getGraphicsContext2D());
        this.rendererFactory = new JavaFXRendererFactory();

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

        Platform.runLater(this::handleInput);
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
    public Set<SceneInput<?>> getInputs() {
        return Stream.of(this.getKeyboardInput(), this.getMouseInput())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleInput() {
        // Keyboard
        this.getKeyboardInput().ifPresent(keyboardInput -> {
            this.scene.setOnKeyPressed(e -> keyboardInput.addInput(e.getCode()));
            this.scene.setOnKeyReleased(e -> keyboardInput.removeInput(e.getCode()));
        });
        // Mouse
        this.getMouseInput().ifPresent(mouseInput -> {
            this.scene.setOnMousePressed(e -> mouseInput.addInput(e.getButton()));
            this.scene.setOnMouseReleased(e -> mouseInput.removeInput(e.getButton()));
        });
    }

    /**
     * @return keyboard input source
     * @implNote bindings are implementation-specific and don't exist by default
     */
    public Optional<SceneInput<KeyCode>> getKeyboardInput() {
        return Optional.empty();
    }

    /**
     * @return mouse input source
     * @implNote bindings are implementation-specific and don't exist by default
     */
    public Optional<SceneInput<MouseButton>> getMouseInput() {
        return Optional.empty();
    }
}
