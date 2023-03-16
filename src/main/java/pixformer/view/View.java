package pixformer.view;

import pixformer.common.Updatable;
import pixformer.view.engine.GameScene;
import pixformer.view.engine.camera.Camera;

/**
 * The view of the game.
 */
public interface View extends Updatable {

    /**
     * Set-ups the scene.
     */
    void setup();

    /**
     * @return the active game scene
     */
    GameScene getScene();

    /**
     * @return the current game camera
     */
    Camera getCamera();

    /**
     * Sets a new game camera.
     * @param camera new camera to set
     */
    void setCamera(Camera camera);
}
