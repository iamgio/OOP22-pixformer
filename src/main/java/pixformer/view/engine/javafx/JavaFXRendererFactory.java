package pixformer.view.engine.javafx;

import pixformer.view.engine.Color;
import pixformer.view.engine.RectangleRenderer;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.TextRenderer;

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
    public RectangleRenderer newRectangle(final double width, final double height) {
        return new JavaFXRectangleRenderer(width, height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Renderer newSolidBackground(final Color color) {
        return new JavaFXSolidBackgroundRenderer(color.toJFX());
    }
}
