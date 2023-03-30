package pixformer.model.entity.dynamic.enemy.koopa.walking;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import pixformer.common.TriConsumer;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentRetriever;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.dynamic.enemy.EnemyImpl;
import pixformer.model.entity.dynamic.enemy.koopa.Koopa;
import pixformer.model.entity.dynamic.enemy.koopa.KoopaState;

/**
 * The state of the koopa which walks normally and behaves like a goomba.
 */
public final class WalkingKoopa extends EnemyImpl implements KoopaState, DrawableEntity, Koopa {

    private static final double INITIAL_VELOCITY = 0.002; // calcoli fatti a mano
    private static final double WIDTH = 1;
    private static final double HEIGHT = 2;
    private final CollisionComponent collisionComponent;
    private final GraphicsComponent graphicsComponent;
    private final TriConsumer<Double, Double, Entity> turtleFactory;
    private final Consumer<Entity> dieBy;

    /**
     * Construct a WalkingKoopa.
     *
     * @param x             its initial x position
     * @param y             its initial x position.
     * @param turtleFactory for creating a turtle koopa.
     * @param die           for killing the entity.
     */
    public WalkingKoopa(final double x, final double y, final TriConsumer<Double, Double, Entity> turtleFactory,
                        final BiConsumer<Entity, Entity> die,
                        final GraphicsComponentRetriever graphicsComponent) {
        super(x, y, WIDTH, HEIGHT, INITIAL_VELOCITY);
        this.turtleFactory = turtleFactory;
        this.dieBy = killer -> die.accept(this, killer);
        this.collisionComponent = new WalkingKoopaCollisionComponent(this, this::changeToTurtle, dieBy);
        this.graphicsComponent = graphicsComponent.apply(this);
    }

    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(collisionComponent);
    }

    @Override
    public boolean isWalking() {
        return true;
    }

    private void changeToTurtle(final Entity killer) {
        this.dieBy.accept(killer);
        turtleFactory.accept(getX(), getY() + getHeight() - 1, killer);
    }

    @Override
    public GraphicsComponent getGraphicsComponent() {
        return this.graphicsComponent;
    }
}
