package pixformer.view.javafx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import pixformer.view.Graphics;
import pixformer.view.PositionableRenderer;

/**
 * A text renderer for JavaFX.
 */
public class JavaFXTextRenderer extends PositionableRenderer {

    private final String text;
    private final Font font;
    private final Color color;

    /**
     * Creates a text renderer for JavaFX
     * @param text text to render
     * @param color text color
     */
    public JavaFXTextRenderer(final String text, final Color color, final String family, final double size) {
        this.text = text;
        this.color = color;
        this.font = Font.font(family, size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final double dt, final Graphics graphics) {
        GraphicsContext g = JavaFXGraphics.requireJFXGraphics(graphics).getGraphics();
        g.setFill(this.color);
        g.setFont(this.font);
        g.fillText(this.text, super.getX(), super.getY());
    }
}
