package pixformer.view;

import pixformer.common.Updatable;
import pixformer.controller.InputType;

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
     * @see pixformer.view.engine.GameScene#getInputs()
     */
    Set<InputType> getInputs();
}
