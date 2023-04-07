package pixformer.view.engine.javafx;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.SimpleWritableWrapper;
import pixformer.common.wrap.Wrapper;
import pixformer.common.wrap.WritableWrapper;
import pixformer.model.sound.SoundEvent;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.Graphics;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.SceneInput;
import pixformer.view.engine.SceneRenderer;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A JavaFX scene of the game.
 */
public class JavaFXScene extends GameScene {

    private final WritableWrapper<Scene> scene = new SimpleWritableWrapper<>();
    private final Wrapper<SceneRenderer> renderer;
    private final Wrapper<Graphics> graphics;
    private final RendererFactory rendererFactory;
    private final JavaFXPlayer soundPlayer = new JavaFXPlayer();

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

        this.scene.set(new Scene(root));
        this.renderer = new SimpleWrapper<>(new SceneRenderer());
        this.graphics = new SimpleWrapper<>(new JavaFXGraphics(canvas.getGraphicsContext2D()));
        this.rendererFactory = new JavaFXRendererFactory();

        // Makes the canvas resizable by resizing the window

        super.addOnResize((w, h) -> {
            graphics.get().clear();
            this.render();
        });

        root.widthProperty().addListener(o -> {
            canvas.setWidth(root.getWidth());
            super.getOnResize().forEach(action -> action.accept(root.getWidth(), root.getHeight()));
        });

        root.heightProperty().addListener(o -> {
            canvas.setHeight(root.getHeight());
            super.getOnResize().forEach(action -> action.accept(root.getWidth(), root.getHeight()));
        });
    }

    /**
     * @return the wrapped JavaFX scene
     */
    public Scene getScene() {
        return this.scene.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getWidth() {
        return getScene().getWidth();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getHeight() {
        return getScene().getHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SceneRenderer getRenderer() {
        return this.renderer.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Graphics getGraphics() {
        return this.graphics.get();
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
        final Scene scene = this.scene.get();
        // Keyboard
        this.getKeyboardInput().ifPresent(keyboardInput -> {
            scene.setOnKeyPressed(e -> keyboardInput.addInput(e.getCode()));
            scene.setOnKeyReleased(e -> keyboardInput.removeInput(e.getCode()));
        });
        // Mouse
        this.getMouseInput().ifPresent(mouseInput -> {
            scene.setOnMousePressed(e -> mouseInput.addInput(e.getButton()));
            scene.setOnMouseReleased(e -> mouseInput.removeInput(e.getButton()));
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void playSounds(List<SoundEvent> sounds) {
        soundPlayer.play(sounds);        
    }
}
