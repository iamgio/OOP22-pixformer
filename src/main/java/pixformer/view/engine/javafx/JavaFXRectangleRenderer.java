package pixformer.view.engine.javafx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pixformer.view.engine.Graphics;
import pixformer.view.engine.PositionableRenderer;

/**
 * A rectangle renderer for JavaFX.
 */
public class JavaFXRectangleRenderer extends PositionableRenderer {

    private final double width;
    private final double height;
    private final Color color;

    /**
     * Creates a rectangle renderer for JavaFX
     * @param width rectangle width
     * @param height rectangle height
     * @param color fill color
     */
    public JavaFXRectangleRenderer(final double width, final double height, final Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final double dt, final Graphics graphics) {
        GraphicsContext g = JavaFXGraphics.requireJFXGraphics(graphics).getGraphics();
        g.setFill(this.color);
        g.fillRect(super.getX(), super.getY(), this.width, this.height);
    }
}
