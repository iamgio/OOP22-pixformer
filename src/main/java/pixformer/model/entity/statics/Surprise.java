package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;

/**
 * Surprise block, which contains a power-up.
 */
public class Surprise extends AbstractEntity implements DefaultRectangleBoundingBoxEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    /**
     * Constructor of the Surprise block.
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Surprise(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
    }

}
