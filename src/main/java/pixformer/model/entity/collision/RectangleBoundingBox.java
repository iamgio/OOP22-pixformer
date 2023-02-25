package pixformer.model.entity.collision;

/**
 * A rectangle-shaped bounding box defined by width and height.
 */
public class RectangleBoundingBox implements BoundingBox {

    private final double width;
    private final double height;

    /**
     * @param width rectangle width
     * @param height rectangle height
     */
    public RectangleBoundingBox(final double width, final double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean collidesWith(final BoundingBox other, final double x1, final double y1, final double x2, final double y2) {
        if (other instanceof RectangleBoundingBox rectangle) {
            return x1 < x2 + rectangle.width
                    && x1 + this.width > x2
                    && y1 < y2 + rectangle.height
                    && y1 + this.height > y2;
        }
        return false;
    }
}
