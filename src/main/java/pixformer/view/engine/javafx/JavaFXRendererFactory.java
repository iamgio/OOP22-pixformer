package pixformer.view.engine.javafx;

import javafx.scene.image.Image;
import pixformer.view.engine.Color;
import pixformer.view.engine.PositionableRenderer;
import pixformer.view.engine.RectangleRenderer;
import pixformer.view.engine.Renderer;
import pixformer.view.engine.RendererFactory;
import pixformer.view.engine.TextRenderer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public PositionableRenderer newImage(final String resourcePath,
                                         final double width, final double height, final boolean flipX) {
        try (InputStream inputStream = Objects.requireNonNull(RendererFactory.class.getResourceAsStream(resourcePath))) {
            return new JavaFXImageRenderer(new Image(inputStream), width, height, flipX);
        } catch (IOException e) {
            return null;
        }
    }
}
