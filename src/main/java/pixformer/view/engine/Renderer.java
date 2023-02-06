package pixformer.view.engine;

/**
 * Responsible for rendering content on some graphics (canvas).
 */
public interface Renderer {

    /**
     * Renders some content.
     * @param dt delta time
     * @param graphics graphics (canvas) to draw on
     */
    void render(double dt, Graphics graphics);

    /**
     * Renders some content.
     * @param graphics graphics (canvas) to draw on
     */
    default void render(final Graphics graphics) {
        this.render(0, graphics);
    }
}
