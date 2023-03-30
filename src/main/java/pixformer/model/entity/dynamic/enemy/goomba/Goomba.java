package pixformer.model.entity.dynamic.enemy.goomba;

import pixformer.common.Vector2D;
import pixformer.model.World;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentRetriever;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.BoundingBox;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.dynamic.enemy.Enemy;
import pixformer.model.entity.dynamic.enemy.EnemyImpl;
import pixformer.model.input.InputComponent;
import pixformer.model.physics.PhysicsComponent;

import javax.annotation.OverridingMethodsMustInvokeSuper;
import java.util.Optional;

/**
 * The enemy goomba.
 */
public final class Goomba implements DrawableEntity, MutableEntity, Enemy {

    private static final double INITIAL_VELOCITY = 0.002; // calcoli fatti a mano
    private static final double WIDTH = 1;
    private static final double HEIGHT = 1;
    private final EnemyImpl innerEnemy;
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
        innerEnemy = new EnemyImpl(x, y, WIDTH, HEIGHT, INITIAL_VELOCITY);
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
