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
    void setup();

    /**
     * @return the active game scene
     */
    GameScene getScene();
}
