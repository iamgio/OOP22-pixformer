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
     * @implNote the default scale is 1
     */
    void setScale(double scale);

    /**
     * Sets the new origin point.
     * @param x X coordinate
     * @param y Y coordinate
     * @implNote the default origin point is (0,0)
     */
    void setOriginPoint(double x, double y);

    /**
     * Sets the new starting coordinates to use to draw, on top of the origin point.
     * @param x X coordinate
     * @param y Y coordinate
     * @implNote the default translation is (0,0)
     */
    void setTranslate(double x, double y);
}
