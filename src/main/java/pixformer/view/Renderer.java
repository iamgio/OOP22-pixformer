package pixformer.view;

/**
 * Responsible for rendering content on some graphics (canvas)
 */
public interface Renderer {

    /**
     * Renders some content.
     * @param dt delta time
     * @param graphics graphics (canvas) to draw on
     */
    void render(final double dt, final Graphics graphics);
}
