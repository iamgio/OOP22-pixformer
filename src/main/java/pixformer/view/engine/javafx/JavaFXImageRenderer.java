package pixformer.view.engine.javafx;

import javafx.scene.image.Image;
import pixformer.view.engine.Graphics;
import pixformer.view.engine.PositionableRenderer;

/**
 * A static image renderer for JavaFX.
 */
public class JavaFXImageRenderer extends PositionableRenderer {

    private final Image image;
    private final double width;
    private final double height;

    /**
     * Creates a static image renderer for JavaFX.
     * @param image image to render
     * @param width image width
     * @param height image height
     */
    public JavaFXImageRenderer(
            final Image image,
            final double width, final double height
    ) {
        this.image = image;
        this.width = width;
        this.height = height;
    }

    /**
     * Creates a static image renderer for JavaFX.
     * @param image image to render
     */
    public JavaFXImageRenderer(final Image image) {
        this(image, image.getWidth(), image.getHeight());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final double dt, final Graphics graphics) {
        JavaFXGraphics.requireJFXGraphics(graphics).getGraphics().drawImage(image,
                super.getX(), super.getY(), this.width, this.height
        );
    }
}
