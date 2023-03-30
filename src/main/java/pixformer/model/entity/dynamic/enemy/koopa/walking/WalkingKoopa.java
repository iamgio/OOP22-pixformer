package pixformer.model.entity.dynamic.enemy.koopa.walking;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import pixformer.common.TriConsumer;
import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.entity.*;
import pixformer.model.entity.collision.BoundingBox;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.dynamic.enemy.EnemyImpl;
import pixformer.model.entity.dynamic.enemy.koopa.Koopa;
import pixformer.model.entity.dynamic.enemy.koopa.KoopaState;
import pixformer.model.input.InputComponent;
import pixformer.model.physics.PhysicsComponent;

import javax.annotation.OverridingMethodsMustInvokeSuper;

/**
 * The state of the koopa which walks normally and behaves like a goomba.
 */
public final class WalkingKoopa implements DrawableEntity, Koopa, MutableEntity {

    private static final double INITIAL_VELOCITY = 0.002; // calcoli fatti a mano
    private static final double WIDTH = 1;
    private static final double HEIGHT = 2;
    private final EnemyImpl innerEnemy;
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
     * @param graphicsComponent graphics component retriever for the koopa
     */
    public WalkingKoopa(final double x, final double y, final TriConsumer<Double, Double, Entity> turtleFactory,
                        final BiConsumer<Entity, Entity> die,
                        final GraphicsComponentRetriever graphicsComponent) {
        this.innerEnemy = new EnemyImpl(x, y, WIDTH, HEIGHT, INITIAL_VELOCITY);
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

    @Override
    public Optional<World> getWorld() {
        return innerEnemy.getWorld();
    }

    @Override
    public double getX() {
        return innerEnemy.getX();
    }

    @Override
    public void setX(final double x) {
        innerEnemy.setX(x);
    }

    @Override
    public double getY() {
        return innerEnemy.getY();
    }

    @Override
    public void setY(final double y) {
        innerEnemy.setY(y);
    }

    @Override
    public double getWidth() {
        return innerEnemy.getWidth();
    }

    @Override
    public void setWidth(final double width) {
        innerEnemy.setWidth(width);
    }

    @Override
    public double getHeight() {
        return innerEnemy.getHeight();
    }

    @Override
    public void setHeight(final double height) {
        innerEnemy.setHeight(height);
    }

    @Override
    public Vector2D getVelocity() {
        return innerEnemy.getVelocity();
    }

    @Override
    public void setVelocity(final Vector2D velocity) {
        innerEnemy.setVelocity(velocity);
    }

    @Override
    public boolean isSolid() {
        return innerEnemy.isSolid();
    }

    @Override
    @OverridingMethodsMustInvokeSuper
    public void onSpawn(final World world) {
        innerEnemy.onSpawn(world);
    }

    @Override
    @OverridingMethodsMustInvokeSuper
    public void onDespawn(final World world) {
        innerEnemy.onDespawn(world);
    }

    @Override
    public void update(final double dt) {
        innerEnemy.update(dt);
    }

    @Override
    public BoundingBox getBoundingBox() {
        return innerEnemy.getBoundingBox();
    }

    @Override
    public double getDistanceFrom(final Entity other) {
        return innerEnemy.getDistanceFrom(other);
    }

    @Override
    public Optional<PhysicsComponent> getPhysicsComponent() {
        return innerEnemy.getPhysicsComponent();
    }

    @Override
    public Optional<InputComponent> getInputComponent() {
        return innerEnemy.getInputComponent();
    }
}
