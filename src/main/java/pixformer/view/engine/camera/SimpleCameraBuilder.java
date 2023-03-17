package pixformer.view.engine.camera;

/**
 * A builder for a {@link SimpleCamera}.
 */
public class SimpleCameraBuilder {

    private double pivotX = 0;
    private double pivotY = 0;
    private double scale = 1;

    /**
     * Applies an origin point.
     * @param pivotX X coordinate
     * @param pivotY Y coordinate
     * @return this for concatenation
     */
    public SimpleCameraBuilder withPivot(final double pivotX, final double pivotY) {
        this.pivotX = pivotX;
        this.pivotY = pivotY;
        return this;
    }

    /**
     * Applies an offset to the current origin point.
     * @param offsetX X offset
     * @param offsetY Y offset
     * @return this for concatenation
     * @apiNote this should be used after setting the pivot
     */
    public SimpleCameraBuilder withOffset(final double offsetX, final double offsetY) {
        this.pivotX += offsetX;
        this.pivotY += offsetY;
        return this;
    }

    /**
     * Applies a scale.
     * @param scale camera scale (zoom)
     * @return this for concatenation
     */
    public SimpleCameraBuilder withScale(final double scale) {
        this.scale = scale;
        return this;
    }

    /**
     * Builds the camera.
     * @return a new camera instance with the specified properties
     */
    public Camera build() {
        return new SimpleCamera(pivotX, pivotY, scale);
    }
}
