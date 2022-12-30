package pixformer.view.javafx;

import javafx.scene.canvas.GraphicsContext;
import pixformer.view.Graphics;
import pixformer.view.Renderer;

/**
 * Canvas graphics for JavaFX.
 */
public class JavaFXGraphics implements Graphics {

    private final GraphicsContext graphics;

    /**
     * Creates a wrapper for JavaFX graphics.
     * @param graphics graphics to draw on
     */
    public JavaFXGraphics(final GraphicsContext graphics) {
        this.graphics = graphics;
    }

    /**
     * @return JavaFX graphics
     */
    GraphicsContext getGraphics() {
        return this.graphics;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Renderer renderer, final double x, final double y) {
        renderer.render(0, this);
    }
}
