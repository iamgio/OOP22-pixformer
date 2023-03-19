package pixformer.model.entity.dynamic;

import java.util.Optional;

import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.view.engine.Color;
import pixformer.view.entity.RectangleGraphicsComponent;

/**
 * The enemy goomba.
 */
public final class Goomba extends Enemy implements DrawableEntity {

    private static final double INITIAL_VELOCITY = 0.002; // calcoli fatti a mano
    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;

    /**
     * Create a new Goomba.
     * 
     * @param x its initial x coordinate position.
     * @param y its initial y coordinate position.
     */
    public Goomba(final double x, final double y) {
        super(x, y, WIDTH, HEIGHT, INITIAL_VELOCITY);
    }

    @Override
    public GraphicsComponent getGraphicsComponent() {
        return new RectangleGraphicsComponent(this, new Color(0.7, 0.4, 0));
    }

    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return DieOnPressedCollisionComponent.createWithWorldFromEntity(this);
    }

}
