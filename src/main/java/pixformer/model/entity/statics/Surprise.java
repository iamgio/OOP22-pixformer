package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
/**
 * Surprise block, which contains a power-up.
 */
public class Surprise extends AbstractEntity {

    /**
     * Constructor of the Surprise block.
     * @param x X coordinate
     * @param y Y coordinate
     * @param width width of the block
     * @param height height of the block
     */
    public Surprise(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
    }

}
