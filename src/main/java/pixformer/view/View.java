package pixformer.view;

import pixformer.common.Updatable;
import pixformer.controller.InputType;
import pixformer.view.engine.GameScene;

import java.util.Set;

/**
 * The view of the game.
 */
public interface View extends Updatable {

    /**
     * Set-ups the scene.
     */
    void setup();

    /**
     * @return currently active inputs
     * @see GameScene#getInputs()
     */
    Set<InputType> getInputs();
}
