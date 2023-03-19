package pixformer.view.engine.camera;

import pixformer.view.engine.Graphics;

/**
 * A camera is the component that handles a coordinate system
 * in order to display it on screen.
 */
public interface Camera {

    /**
     * Applies the properties of the camera to the scene graphics.
     * @param graphics graphics to operate onto
     * @apiNote this is called every frame <i>before</i> rendering the scene
     */
    void applyBeforeRendering(Graphics graphics);
}
