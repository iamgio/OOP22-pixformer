package pixformer.view.javafx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Renders the solid background of a JavaFX scene.
 */
public class JavaFXSolidBackgroundRenderer extends JavaFXBackgroundRenderer {

    private final Color color;

    /**
     * Creates the background renderer.
     * @param color solid color of the background
     */
    public JavaFXSolidBackgroundRenderer(final Color color) {
        this.color = color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawBackground(final GraphicsContext graphics, final double width, final double height) {
        graphics.setFill(this.color);
        graphics.fillRect(0, 0, width, height);
    }
}
