package pixformer.view;

/**
 * Responsible for launching a kind of view.
 */
public interface ViewLauncher {

    /**
     * Launches the view.
     */
    void launch();

    /**
     * @return the active game scene
     */
    GameScene getScene();
}
