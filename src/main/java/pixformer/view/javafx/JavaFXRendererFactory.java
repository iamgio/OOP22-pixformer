package pixformer.view.javafx;

import pixformer.view.Color;
import pixformer.view.PositionableRenderer;
import pixformer.view.Renderer;
import pixformer.view.RendererFactory;

/**
 * A provider of JavaFX scene components.
 */
public class JavaFXRendererFactory implements RendererFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public PositionableRenderer newText(final String text) {
        return new JavaFXTextRenderer(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Renderer newSolidBackground(Color color) {
        return new JavaFXSolidBackgroundRenderer(color.toJFX());
    }
}
