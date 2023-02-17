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
}
