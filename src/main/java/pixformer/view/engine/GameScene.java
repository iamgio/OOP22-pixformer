package pixformer.view.engine;

import pixformer.controller.InputType;

import java.util.Set;

/**
 * A scene of the game that contains its drawable content.
 */
public abstract class GameScene {

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
     * @return currently active inputs
     */
    public abstract Set<InputType> getInputs();

    /**
     * @return the keyboard input mapping system for this scene
     */
    protected abstract InputMapper<?> getKeyboardInputMapper();

    /**
     * @return the mouse input mapping system for this scene
     */
    protected abstract InputMapper<?> getMouseInputMapper();

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
     * Adds a new renderer to the scene
     * @param renderer renderer to append
     * @see SceneRenderer#add(Renderer) 
     */
    public void add(final Renderer renderer) {
        this.getRenderer().add(renderer);
    }

    /**
     * Removes a renderer from the scene
     * @param renderer renderer to remove
     * @see SceneRenderer#remove(Renderer) 
     */
    public void remove(final Renderer renderer) {
        this.getRenderer().remove(renderer);
    }
}
