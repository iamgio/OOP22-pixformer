package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.common.Vector2D;
import pixformer.model.entity.DrawableEntity;

/**
 * Standard block in the world.
 */
public class Block extends AbstractEntity {

    public Block(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
    }

}
