package pixformer.view.engine.javafx;

import javafx.scene.canvas.GraphicsContext;
import pixformer.view.engine.Graphics;
import pixformer.view.engine.RectangleRenderer;

/**
 * A rectangle renderer for JavaFX.
 */
public class JavaFXRectangleRenderer extends RectangleRenderer {

    /**
     * Creates a rectangle renderer for JavaFX.
     * @param width rectangle width
     * @param height rectangle height
     */
    public JavaFXRectangleRenderer(final double width, final double height) {
        super(width, height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final double dt, final Graphics graphics) {
        GraphicsContext g = JavaFXGraphics.requireJFXGraphics(graphics).getGraphics();
        g.setFill(super.getColor().toJFX());
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
}
