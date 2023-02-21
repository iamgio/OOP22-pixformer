package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
/**
 * Standard block in the world.
 */
public class Block extends AbstractEntity {

    /**
     * Constructor of the Block.
     * @param x X coordinate
     * @param y Y coordinate
     * @param width width of the block
     * @param height height of the block
     */
    public Block(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
    }

}
