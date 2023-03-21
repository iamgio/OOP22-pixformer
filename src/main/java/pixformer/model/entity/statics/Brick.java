package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.*;
import pixformer.view.entity.statics.BrickGraphicsComponent;

import java.util.Optional;

/**
 * Brick block, common brick block which can be destroyed from the bottom.
 */
public class Brick extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, SolidEntity, DrawableEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;
    private final GraphicsComponent graphicsComponent;
    private final CollisionComponent collisionComponent;

    /**
     * Simple constructor of the Block.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Brick(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
        this.collisionComponent = new BrickCollisionComponent(this);
        this.graphicsComponent = new BrickGraphicsComponent(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(this.collisionComponent);
    }
}
