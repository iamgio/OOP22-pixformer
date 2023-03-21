package pixformer.model.entity.dynamic;

import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.view.entity.enemies.GoombaGraphicsComponent;

import java.util.Optional;

/**
 * The enemy goomba.
 */
public final class Goomba extends Enemy implements DrawableEntity {

    private static final double INITIAL_VELOCITY = 0.002; // calcoli fatti a mano
    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    private final GraphicsComponent graphicsComponent;

    /**
     * Create a new Goomba.
     * 
     * @param x its initial x coordinate position.
     * @param y its initial y coordinate position.
     */
    public Goomba(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT, INITIAL_VELOCITY);
        this.graphicsComponent = new GoombaGraphicsComponent(this);
    }

    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }

    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return DieOnPressedCollisionComponent.createWithWorldFromEntity(this);
    }

}
