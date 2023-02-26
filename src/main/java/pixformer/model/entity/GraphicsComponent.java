package pixformer.model.entity;

import pixformer.view.engine.GameScene;

/**
 * An entity's component responsible for its rendering on screen, or another
 * output.
 */
public interface GraphicsComponent {

    /**
     * Updates the game scene with the content to draw.
     * 
     * @param scene game scene to draw on
     */
    void update(GameScene scene);
}
