package pixformer.model.entity.dynamic.enemy.koopa.turtle;

import java.util.Optional;
import java.util.function.BiConsumer;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentRetriever;
import pixformer.model.entity.Projectile;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.entity.dynamic.enemy.koopa.Koopa;
import pixformer.model.input.InputComponent;
import pixformer.model.physics.PhysicsComponent;

/**
 * The state of the koopa when it is a turtle.
 */
public final class TurtleKoopa extends AbstractEntity implements DefaultRectangleBoundingBoxEntity, DrawableEntity,
        Projectile, Koopa {
    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;
    private final Entity shooter;
    private final InputComponent inputComponent;
    private final PhysicsComponent physicsComponent;
    private final CollisionComponent collisionComponent;
    private final GraphicsComponent graphicsComponent;

    /**
     * Create a new TurtleKoopa.
     *
     * @param x its initial x position
     * @param y its initial y position.
     * @param die called by passing the killer entity, it kills this entity.
     * @param graphicsComponentRetriever for retrieving the {@link GraphicsComponent} for this entity.
     */
    public TurtleKoopa(final double x, final double y,final Entity shooter, final BiConsumer<Entity, Entity> die,
                       final GraphicsComponentRetriever graphicsComponentRetriever) {
        super(x, y, WIDTH, HEIGHT);
        this.shooter = shooter;
        inputComponent = new TurtleKoopaInputComponent(this);
        physicsComponent = new PhysicsComponent(this);
        collisionComponent = new TurtleKoopaCollisionComponent(this, killer -> die.accept(this, killer));
        graphicsComponent = graphicsComponentRetriever.apply(this);
    }
    @Override
    public boolean isWalking() {
        return false;
    }

    @Override
    public Optional<InputComponent> getInputComponent() {
        return Optional.of(inputComponent);
    }
    @Override
    public Optional<PhysicsComponent> getPhysicsComponent() {
        return Optional.of(physicsComponent);
    }
    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(collisionComponent);
    }
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return graphicsComponent;
    }

    @Override
    public Entity getShooter() {
        return shooter;
    }
}
