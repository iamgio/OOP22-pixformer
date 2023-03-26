package pixformer.view.engine;

/**
 * A provider of scene components.
 */
public interface RendererFactory {

    /**
     * @param text text to display
     * @return a new text renderer
     */
    TextRenderer newText(String text);

    /**
     * @param width rectangle width
     * @param height rectangle height
     * @return a new rectangle renderer
     */
    RectangleRenderer newRectangle(double width, double height);

    /**
     * @param color background color
     * @return a new solid background renderer
     */
    Renderer newSolidBackground(Color color);

    /**
     * @param resourcePath path to an internal image resource
     * @param width width of the image
     * @param height height of the image
     * @param flipX whether the image should be flipped horizontally
     * @return a new image renderer
     */
    PositionableRenderer newImage(String resourcePath, double width, double height, boolean flipX);

    /**
     * @param resourcePath path to an internal image resource
     * @param width width of the image
     * @param height height of the image
     * @return a new image renderer
     */
    default PositionableRenderer newImage(String resourcePath, double width, double height) {
        return this.newImage(resourcePath, width, height, false);
    }
}
