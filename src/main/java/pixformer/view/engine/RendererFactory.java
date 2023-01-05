package pixformer.view.engine;

/**
 * A provider of scene components.
 */
public interface RendererFactory {

    /**
     * @param text text to display
     * @return a new text renderer
     */
    TextRenderer newText(final String text);

    /**
     * @param width rectangle width
     * @param height rectangle height
     * @return a new rectangle renderer
     * @param color fill color
     */
    PositionableRenderer newRectangle(final double width, final double height, final Color color);

    /**
     * @param color background color
     * @return a new solid background renderer
     */
    Renderer newSolidBackground(final Color color);

    // Renderer newImage(Image image);
    // TODO needs wrapping or sprite enum
}
