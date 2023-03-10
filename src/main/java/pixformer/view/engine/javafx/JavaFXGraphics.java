package pixformer.view.engine.javafx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import pixformer.common.wrap.SimpleWrapper;
import pixformer.common.wrap.Wrapper;
import pixformer.view.engine.Graphics;
import pixformer.view.engine.Renderer;

import java.util.Objects;

/**
 * Canvas graphics for JavaFX.
 */
public class JavaFXGraphics implements Graphics {

    private final Wrapper<GraphicsContext> graphics;

    private double translationX;
    private double translationY;

    /**
     * Creates a wrapper for JavaFX graphics.
     * @param graphics graphics to draw on
     */
    public JavaFXGraphics(final GraphicsContext graphics) {
        this.graphics = new SimpleWrapper<>(graphics);
    }

    /**
     * @return JavaFX graphics
     */
    GraphicsContext getGraphics() {
        return this.graphics.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Renderer renderer) {
        renderer.render(0, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        final GraphicsContext graphics = this.graphics.get();
        final Canvas canvas = Objects.requireNonNull(graphics.getCanvas());
        graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setScale(final double scale) {
        this.graphics.get().scale(scale, scale);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTranslate(final double x, final double y) {
        this.graphics.get().translate(x - this.translationX, y - this.translationY);
        this.translationX = x;
        this.translationY = y;
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
