package pixformer.view.engine.javafx;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.Graphics;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.SceneRenderer;

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
        Canvas canvas = new Canvas();
        AnchorPane root = new AnchorPane(canvas);
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
     * Handles keyboard and mouse input.
     * It does nothing by default and hence is implementation-specific.
     */
    public void handleInput() {}
}
