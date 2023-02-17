package pixformer.view.engine;

/**
 * Allows drawing on a canvas.
 */
public interface Graphics {

    /**
     * Draws and renders some content.
     * @param renderer content to render
     */
    void draw(Renderer renderer);

    /**
     * Clears what was previously rendered.
     */
    void clear();

    /**
     * Sets a scale factor for the next renders.
     * @param scale scale factor
     */
    void setScale(double scale);

    /**
     * Sets the new coordinates to use as the origin point to draw.
     * @param x X coordinate
     * @param y Y coordinate
     * @implNote the default translation is (0,0)
     */
    void setTranslate(double x, double y);
}
