package pixformer.view;

/**
 * Allows drawing on a canvas.
 */
public interface Graphics {

    /**
     * Draws and renders some content.
     * @param renderer content to render
     * @param x X coordinate
     * @param y Y coordinate
     */
    void draw(final Renderer renderer, final double x, final double y);

    /**
     * Clears what was previously rendered.
     */
    void clear();
}
