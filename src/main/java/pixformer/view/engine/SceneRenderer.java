package pixformer.view.engine;

import java.util.LinkedList;
import java.util.List;

/**
 * Dynamically renders the content of a {@link GameScene}.
 */
public class SceneRenderer implements Renderer {

    private final List<Renderer> renderers;

    /**
     * Creates a scene renderer.
     * @param renderers initial content
     */
    public SceneRenderer(final List<Renderer> renderers) {
        this.renderers = new LinkedList<>(renderers);
    }

    /**
     * Creates an empty scene renderer.
     */
    public SceneRenderer() {
        this.renderers = new LinkedList<>();
    }

    /**
     * @return a mutable, ordered list of components to render
     */
    public List<Renderer> getRenderers() {
        return this.renderers;
    }

    /**
     * Adds a new renderer to the scene
     * @param renderer renderer to append
     */
    public void add(final Renderer renderer) {
        this.renderers.add(renderer);
    }

    /**
     * Removes a renderer from the scene
     * @param renderer renderer to remove
     */
    public void remove(final Renderer renderer) {
        this.renderers.remove(renderer);
    }

    /**
     * Renders the content of multiple renderers.
     * @param dt delta time
     * @param graphics graphics (canvas) to draw on
     */
    @Override
    public void render(double dt, Graphics graphics) {
        this.renderers.forEach(renderer -> renderer.render(dt, graphics));
    }
}
