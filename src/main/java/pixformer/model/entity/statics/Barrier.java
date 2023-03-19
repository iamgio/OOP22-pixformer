package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.collision.SolidEntity;

/**
 * Block without graphic component working as a border in the map.
 */
public class Barrier extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, SolidEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    /**
     * Constructor for the Barrier.
     *
     * @param x      X coordinate
     * @param y      Y coordinate
     */
    public Barrier(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
