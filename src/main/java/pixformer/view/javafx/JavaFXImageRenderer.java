package pixformer.view.javafx;

import javafx.scene.image.Image;
import pixformer.view.Graphics;
import pixformer.view.Renderer;

/**
 * A static image renderer for JavaFX.
 */
public class JavaFXImageRenderer implements Renderer {

    private final Image image;
    private final int x;
    private final int y;

    /**
     * Creates a static image renderer for JavaFX
     * @param image image to render
     * @param x X coordinate
     * @param y Y coordinate
     */
    public JavaFXImageRenderer(final Image image, final int x, final int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a static image renderer for JavaFX
     * @param image image to render
     */
    public JavaFXImageRenderer(final Image image) {
        this(image, 0, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final double dt, final Graphics graphics) {
        assert graphics instanceof JavaFXGraphics;
        ((JavaFXGraphics) graphics).getGraphics().drawImage(image, this.x, this.y);
    }
}
