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
    private final double sourceX;
    private final double sourceY;

    /**
     * Creates a static image renderer for JavaFX
     * @param image image to render
     * @param width image width
     * @param height image height
     * @param sourceX starting X coordinate of the image
     * @param sourceY starting Y coordinate of the image
     */
    public JavaFXImageRenderer(final Image image, final double width, final double height, final double sourceX, final double sourceY) {
        this.image = image;
        this.width = width;
        this.height = height;
        this.sourceX = sourceX;
        this.sourceY = sourceY;
    }

    /**
     * Creates a static image renderer for JavaFX
     * @param image image to render
     */
    public JavaFXImageRenderer(final Image image) {
        this(image, image.getWidth(), image.getHeight(), 0D, 0D);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final double dt, final Graphics graphics) {
        JavaFXGraphics.requireJFXGraphics(graphics).getGraphics().drawImage(image,
                this.sourceX, this.sourceY, this.width, this.height,
                super.getX(), super.getY(), this.width, this.height
        );
    }
}
