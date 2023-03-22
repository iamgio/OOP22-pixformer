package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentRetriever;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.collision.SolidEntity;

/**
 * Standard block in the world, indestructible block in the world.
 */
public class Block extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, SolidEntity, DrawableEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    private final GraphicsComponent graphicsComponent;

    /**
     * Simple constructor of the Block.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     * @param graphicsComponent graphics component of the block
     */
    public Block(final double x, final double y, final GraphicsComponentRetriever graphicsComponent) {
        super(x, y, WIDTH, HEIGHT);
        this.graphicsComponent = graphicsComponent.apply(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }
}
