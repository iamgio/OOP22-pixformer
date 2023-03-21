package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.*;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.view.engine.Color;
import pixformer.view.entity.RectangleGraphicsComponent;

import java.util.Optional;
import java.util.Set;

/**
 * Surprise block, which contains a power-up.
 */
public class Surprise extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, SolidEntity, DrawableEntity {

    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    private final GraphicsComponent graphicsComponent;
    private final CollisionComponent collisionComponent;

    /**
     * Constructor of the Surprise block.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Surprise(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT);
        this.collisionComponent = new SurpriseCollisionComponent(this);
        this.graphicsComponent = new RectangleGraphicsComponent(this, new Color(1, 0, 1));
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
