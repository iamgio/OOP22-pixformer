package pixformer.view;

/**
 * A scene of the game that contains its drawable content.
 */
public interface GameScene {

    /**
     * @return the component responsible for rendering this scene
     */
    SceneRenderer getRenderer();

    /**
     * @return the graphics (canvas) to draw on
     */
    Graphics getGraphics();

    /**
     * Renders the content of this scene.
     * @see Renderer#render(Graphics)
     */
    default void render() {
        this.getRenderer().render(this.getGraphics());
    }
}
