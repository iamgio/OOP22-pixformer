package pixformer.view.engine.camera;

/**
 * A camera that sets a visual origin point within a view.
 *
 * @param pivotX X coordinate of the origin point
 * @param pivotY Y coordinate of the origin point
 */
public record Camera(double pivotX, double pivotY) {

    /**
     * The default camera used at startup.
     */
    public static final Camera DEFAULT_CAMERA = new Camera(0, 0);
}
