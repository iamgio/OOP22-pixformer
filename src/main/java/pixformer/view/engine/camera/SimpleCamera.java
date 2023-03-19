package pixformer.view.engine.camera;

import pixformer.view.engine.Graphics;

/**
 * A camera that sets an origin point and scale within a view.
 *
 * @param pivotX X coordinate of the origin point
 * @param pivotY Y coordinate of the origin point
 * @param scale camera scaling (e.g. if scale = 10, 1 "world pixel" = 10 screen pixels)
 */
public record SimpleCamera(double pivotX, double pivotY, double scale) implements Camera {

    /**
     * The default camera used at startup.
     */
    public static final SimpleCamera DEFAULT_CAMERA = new SimpleCamera(0, 0, 1);

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyBeforeRendering(final Graphics graphics) {
        graphics.setOriginPoint(-pivotX, -pivotY);
        graphics.setScale(scale);
    }
}
