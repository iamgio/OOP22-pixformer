package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentRetriever;
import pixformer.model.entity.collision.CoinCollisionComponent;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.collision.SolidEntity;
import pixformer.view.engine.Color;
import pixformer.view.entity.RectangleGraphicsComponent;

import java.util.Optional;

public class Coin extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, SolidEntity, DrawableEntity  {

    private static final int HEIGHT = 2;
    private static final int WIDTH = 2;

    private final GraphicsComponent graphicsComponent;
    private final CollisionComponent collisionComponent;

    /**
     * Simple constructor for a coin in the game.
     * @param x X coordinate
     * @param y Y coordinate
     * @param graphicsComponent retriever for the graphics component for the entity
     */
    public Coin (final int x, final int y, final GraphicsComponentRetriever graphicsComponent) {
        super(x, y, WIDTH, HEIGHT);
        this.graphicsComponent = graphicsComponent.apply(this);
        this.collisionComponent = new CoinCollisionComponent(this);
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
