package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.collision.SolidEntity;
import pixformer.view.entity.RectangleGraphicsComponent;

/**
 * Standard block in the world.
 */
public class Block extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, SolidEntity, DrawableEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    private final GraphicsComponent graphicsComponent;

    /**
     * Constructor of the Block.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Block(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
        this.graphicsComponent = new RectangleGraphicsComponent(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }
}
