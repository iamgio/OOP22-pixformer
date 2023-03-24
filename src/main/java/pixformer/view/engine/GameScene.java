package pixformer.view.engine;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * A scene of the game that contains its drawable content.
 */
public abstract class GameScene {

    protected final List<BiConsumer<Double, Double>> onResize = new LinkedList<>();

    /**
     * @return width of the scene
     */
    public abstract double getWidth();

    /**
     * @return height of the scene
     */
    public abstract double getHeight();

    /**
     * @return the component responsible for rendering this scene
     */
    public abstract SceneRenderer getRenderer();

    /**
     * @return the graphics (canvas) to draw on
     */
    public abstract Graphics getGraphics();

    /**
     * @return a provider of components for this scene
     */
    public abstract RendererFactory getRendererFactory();

    /**
     * @return currently active input sources
     */
    public abstract Set<SceneInput<?>> getInputs();

    /**
     * Handles keyboard and mouse input.
     */
    protected abstract void handleInput();

    /**
     * Renders the content of this scene.
     * @see Renderer#render(Graphics)
     */
    public final void render() {
        this.getRenderer().render(this.getGraphics());
    }

    /**
     * Adds a new renderer to the scene.
     * @param renderer renderer to append
     * @see SceneRenderer#add(Renderer) 
     */
    public void add(final Renderer renderer) {
        this.getRenderer().add(renderer);
    }

    /**
     * Removes a renderer from the scene.
     * @param renderer renderer to remove
     * @see SceneRenderer#remove(Renderer) 
     */
    public void remove(final Renderer renderer) {
        this.getRenderer().remove(renderer);
    }

    /**
     * Adds an action to be executed when the scene is resized.
     * @param action action with the new width and the new height as arguments
     */
    public void addOnResize(final BiConsumer<Double, Double> action) {
        this.onResize.add(action);
    }
}
