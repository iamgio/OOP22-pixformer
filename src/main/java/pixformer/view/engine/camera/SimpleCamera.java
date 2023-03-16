package pixformer.view.engine.camera;

import pixformer.view.engine.Graphics;

/**
 * A camera that sets an origin point within a view.
 *
 * @param pivotX X coordinate of the origin point
 * @param pivotY Y coordinate of the origin point
 */
public record SimpleCamera(double pivotX, double pivotY) implements Camera {

    /**
     * The default camera used at startup.
     */
    public static final SimpleCamera DEFAULT_CAMERA = new SimpleCamera(0, 0);

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyBeforeRendering(final Graphics graphics) {
        graphics.setOriginPoint(-pivotX, -pivotY);
    }
}
