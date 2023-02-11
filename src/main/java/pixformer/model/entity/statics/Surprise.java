package pixformer.model.entity.statics;

import pixformer.model.entity.GraphicsComponent;
import pixformer.common.Vector2D;

/**
 * {@inheritDoc}
 * Surprise block, which contains a power-up.
 */
public class Surprise extends Block {

    public Surprise(final Vector2D position, final double width, final double height,
                    final GraphicsComponent graphicsComponent) {
        super(position, width, height, graphicsComponent);
    }
}
