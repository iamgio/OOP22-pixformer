package pixformer.model.entity.statics;

import pixformer.model.entity.GraphicsComponent;
import pixformer.common.Vector2D;

/**
 * {@inheritDoc}
 * Brick block, common block which can be destroyed.
 */
public class Brick extends Block {

    public Brick(final Vector2D position, final double width, final double height,
                 final GraphicsComponent graphicsComponent) {
        super(position, width, height, graphicsComponent);
    }
}
