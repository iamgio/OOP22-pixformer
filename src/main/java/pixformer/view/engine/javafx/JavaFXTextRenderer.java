package pixformer.view.engine.javafx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import pixformer.view.engine.Graphics;
import pixformer.view.engine.TextRenderer;

/**
 * A text renderer for JavaFX.
 */
public class JavaFXTextRenderer extends TextRenderer {

    /**
     * The default font size if not specified.
     */
    private static final double DEFAULT_FONT_SIZE = 16;

    private Font font;

    /**
     * Creates a text renderer for JavaFX.
     * @param text text to display
     */
    public JavaFXTextRenderer(final String text) {
        super(text);
        super.setFontSize(DEFAULT_FONT_SIZE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFontFamily(final String fontFamily) {
        super.setFontFamily(fontFamily);
        this.font = Font.font(fontFamily, super.getFontSize());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFontSize(final double fontSize) {
        super.setFontSize(fontSize);
        this.font = Font.font(super.getFontFamily(), fontSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final double dt, final Graphics graphics) {
        final GraphicsContext g = JavaFXGraphics.requireJFXGraphics(graphics).getGraphics();
        g.setFill(super.getColor().toJFX());
        if (this.font != null) {
            g.setFont(this.font);
        }
        g.fillText(super.getText(), super.getX(), super.getY());
    }
}
