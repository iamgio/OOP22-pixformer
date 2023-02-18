package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.common.Vector2D;

/**
 * Brick block, common block which can be destroyed.
 */
public class Brick extends AbstractEntity {

    public Brick(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
    }

}
