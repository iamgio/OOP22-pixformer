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

    // Renderer newImage(Image image);
    // TODO needs wrapping or sprite enum
}
