package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;

/**
 * Standard block in the world.
 */
public class Block extends AbstractEntity implements DefaultRectangleBoundingBoxEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    /**
     * Constructor of the Block.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Block(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
    }

}
