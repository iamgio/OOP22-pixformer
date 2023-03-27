package pixformer.model.entity.statics;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentRetriever;
import pixformer.model.entity.collision.CoinCollisionComponent;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;

import java.util.Optional;

/**
 * In-game coin, a simple entity that give points to the player.
 */
public class Coin extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, DrawableEntity  {

    private static final int HEIGHT = 1;
    private static final int WIDTH = 1;

    private final GraphicsComponent graphicsComponent;
    private final CollisionComponent collisionComponent;

    /**
     * Simple constructor for a coin in the game.
     * @param x X coordinate
     * @param y Y coordinate
     * @param graphicsComponent retriever for the graphics component for the entity
     */
    public Coin(final int x, final int y, final GraphicsComponentRetriever graphicsComponent) {
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
