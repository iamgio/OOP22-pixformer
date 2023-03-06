package pixformer.model.entity.statics;

import pixformer.common.Vector2D;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;

/**
 * Brick block, common block which can be destroyed.
 */
public class Brick extends AbstractEntity implements DefaultRectangleBoundingBoxEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    /**
     * Constructor of the Block.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Brick(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT, new Vector2D(0, 0));
    }

}
