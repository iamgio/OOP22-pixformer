package pixformer.view.javafx;

import javafx.scene.canvas.GraphicsContext;
import pixformer.view.Graphics;
import pixformer.view.PositionableRenderer;

/**
 * A text renderer for JavaFX.
 */
public class JavaFXTextRenderer extends PositionableRenderer {

    private final String text;

    /**
     * Creates a text renderer for JavaFX
     * @param text text to render
     */
    public JavaFXTextRenderer(final String text) {
        this.text = text;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final double dt, final Graphics graphics) {
        GraphicsContext g = JavaFXGraphics.requireJFXGraphics(graphics).getGraphics();
        g.fillText(this.text, super.getX(), super.getY());
    }
}
