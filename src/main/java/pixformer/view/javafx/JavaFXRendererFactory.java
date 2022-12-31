package pixformer.view.javafx;

import pixformer.view.*;

/**
 * A provider of JavaFX scene components.
 */
public class JavaFXRendererFactory implements RendererFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public PositionableRenderer newText(String text, Color color, String family, double size) {
        return new JavaFXTextRenderer(text, color.toJFX(), family, size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PositionableRenderer newText(final String text) {
        return newText(text, Color.BLACK, null, TextBuilder.DEFAULT_FONT_SIZE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Renderer newSolidBackground(Color color) {
        return new JavaFXSolidBackgroundRenderer(color.toJFX());
    }
}
