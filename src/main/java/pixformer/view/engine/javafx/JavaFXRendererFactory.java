package pixformer.view.engine.javafx;

import pixformer.view.engine.*;

/**
 * A provider of JavaFX scene components.
 */
public class JavaFXRendererFactory implements RendererFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public TextRenderer newText(final String text) {
        return new JavaFXTextRenderer(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PositionableRenderer newRectangle(double width, double height, Color color) {
        return new JavaFXRectangleRenderer(width, height, color.toJFX());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Renderer newSolidBackground(Color color) {
        return new JavaFXSolidBackgroundRenderer(color.toJFX());
    }
}
