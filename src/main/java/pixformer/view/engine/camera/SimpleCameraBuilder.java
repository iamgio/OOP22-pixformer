package pixformer.view.engine.camera;

import pixformer.model.entity.Entity;

import java.util.Set;

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
     * Applies the X coordinate of a common origin point among the entities.
     * @param entities entities to find a common point of
     * @return this for concatenation
     * @implNote the common point is the average value of the entities' X coordinates
     */
    public SimpleCameraBuilder withEntityCenteringX(final Set<Entity> entities) {
        return this.withPivot(entities.stream().mapToDouble(Entity::getX).average().orElse(this.pivotX), this.pivotY);
    }

    /**
     * Applies the Y coordinate of a common origin point among the entities.
     * @param entities entities to find a common point of
     * @return this for concatenation
     * @implNote the common point is the average value of the entities' Y coordinates
     */
    public SimpleCameraBuilder withEntityCenteringY(final Set<Entity> entities) {
        return this.withPivot(this.pivotX, entities.stream().mapToDouble(Entity::getY).average().orElse(this.pivotY));
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
