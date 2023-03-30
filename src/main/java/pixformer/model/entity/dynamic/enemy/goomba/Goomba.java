package pixformer.model.entity.dynamic.enemy.goomba;

import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentRetriever;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.dynamic.enemy.EnemyImpl;

import java.util.Optional;

/**
 * The enemy goomba.
 */
public final class Goomba extends EnemyImpl implements DrawableEntity {

    private static final double INITIAL_VELOCITY = 0.002; // calcoli fatti a mano
    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    private final GraphicsComponent graphicsComponent;

    private final CollisionComponent collisionComponent = new GoombaCollisionComponent(this);

    /**
     * Create a new Goomba.
     * 
     * @param x its initial x coordinate position.
     * @param y its initial y coordinate position.
     * @param graphicsComponent graphics component retriever
     */
    public Goomba(final double x, final double y, final GraphicsComponentRetriever graphicsComponent) {
        super(x, y, WIDTH, HEIGHT, INITIAL_VELOCITY);
        this.graphicsComponent = graphicsComponent.apply(this);
    }

    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }

    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(collisionComponent);
    }

}
