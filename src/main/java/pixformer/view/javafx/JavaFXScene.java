package pixformer.view.javafx;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import pixformer.view.GameScene;
import pixformer.view.Graphics;
import pixformer.view.RendererFactory;
import pixformer.view.SceneRenderer;

/**
 * A JavaFX scene of the game.
 */
public class JavaFXScene implements GameScene {

    private final Scene scene;
    private final SceneRenderer renderer;
    private final Graphics graphics;
    private final RendererFactory rendererFactory;

    /**
     * Creates a JavaFX {@link Canvas}-based game scene.
     */
    public JavaFXScene() {
        Canvas canvas = new Canvas();
        AnchorPane root = new AnchorPane(canvas);

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
}
