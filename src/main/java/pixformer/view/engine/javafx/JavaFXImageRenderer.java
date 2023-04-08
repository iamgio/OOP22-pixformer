package pixformer.view.engine.javafx;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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
    private final boolean flipX;

    /**
     * Creates a static image renderer for JavaFX.
     * @param image image to render
     * @param width image width
     * @param height image height
     * @param flipX whether the image should be flipped horizontally
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "JavaFX Image is mutable but is used as immutable here")
    public JavaFXImageRenderer(
            final Image image,
            final double width, final double height, final boolean flipX
    ) {
        this.image = image;
        this.width = width;
        this.height = height;
        this.flipX = flipX;
    }

    /**
     * Creates a static image renderer for JavaFX.
     * @param image image to render
     */
    public JavaFXImageRenderer(final Image image) {
        this(image, image.getWidth(), image.getHeight(), false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final double dt, final Graphics graphics) {
        final double x = flipX ? super.getX() + this.width : super.getX();
        final double width = this.flipX ? -this.width : this.width;
        JavaFXGraphics.requireJFXGraphics(graphics).getGraphics().drawImage(image,
                x, super.getY(),
                width, this.height
        );
    }
}
