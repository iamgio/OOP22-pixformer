package pixformer.view;

import pixformer.common.Updatable;
import pixformer.view.engine.GameScene;

/**
 * The view of the game.
 */
public interface View extends Updatable {

    /**
     * Set-ups the scene.
     */
    void init();

    /**
     * @return the active game scene
     */
    GameScene getScene();

    /**
     * Sets a new game camera.
     *
     * @param pivotX X coordinate of the center point
     * @param pivotY Y coordinate of the center point
     */
    void updateCamera(double pivotX, double pivotY);
}
