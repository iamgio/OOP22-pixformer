package pixformer.view.javafx;

import javafx.scene.image.Image;
import pixformer.view.Graphics;
import pixformer.view.PositionableRenderer;

/**
 * A static image renderer for JavaFX.
 */
public class JavaFXImageRenderer extends PositionableRenderer {

    private final Image image;

    /**
     * Creates a static image renderer for JavaFX
     * @param image image to render
     */
    public JavaFXImageRenderer(final Image image) {
        this.image = image;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final double dt, final Graphics graphics) {
        JavaFXGraphics.requireJFXGraphics(graphics).getGraphics().drawImage(image, super.getX(), super.getY());
    }
}
