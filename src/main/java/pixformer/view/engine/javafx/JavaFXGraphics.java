package pixformer.view.engine.javafx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import pixformer.view.engine.Graphics;
import pixformer.view.engine.Renderer;

import java.util.Objects;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        Canvas canvas = Objects.requireNonNull(this.graphics.getCanvas());
        this.graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    /**
     *
     * @param graphics generic graphics
     * @return the given graphics as JavaFX graphics, if compatible
     * @throws AssertionError if the given graphics are not {@link JavaFXGraphics}
     */
    public static JavaFXGraphics requireJFXGraphics(final Graphics graphics) throws AssertionError {
        assert graphics instanceof JavaFXGraphics;
        return (JavaFXGraphics) graphics;
    }
}
