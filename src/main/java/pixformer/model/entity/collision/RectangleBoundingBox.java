package pixformer.model.entity.collision;

import java.util.Optional;

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
    public Optional<CollisionSide> getCollisionSide(final BoundingBox other,
                                                    final double x1, final double y1,
                                                    final double x2, final double y2) {
        if (other instanceof RectangleBoundingBox rectangle) {
            double dx = (x1 + this.width / 2) - (x2 + rectangle.width / 2);
            double dy = (y1 + this.height / 2) - (y2 + rectangle.height / 2);
            double width = (this.width + rectangle.width) / 2;
            double height = (this.height + rectangle.height) / 2;
            double crossWidth = width * dy;
            double crossHeight = height * dx;

            if (Math.abs(dx) <= width && Math.abs(dy) <= height) {
                if (crossWidth > crossHeight) {
                    return Optional.of(crossWidth > -crossHeight ? CollisionSide.TOP : CollisionSide.LEFT);
                } else {
                    return Optional.of(crossWidth > -crossHeight ? CollisionSide.RIGHT : CollisionSide.BOTTOM);
                }
            }
        }
        return Optional.empty();
    }
}
