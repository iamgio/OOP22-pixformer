package pixformer.model.entity.powerup.other.fireball;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.GraphicsComponentRetriever;
import pixformer.model.entity.Projectile;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.physics.PhysicsComponent;
import pixformer.view.entity.powerups.fireball.FireballGraphicsComponent;

import java.util.Optional;

/**
 * Rapresenting fireball object spawned by player with FireFlower powerup.
 */
public class Fireball extends AbstractEntity implements DrawableEntity, DefaultRectangleBoundingBoxEntity, Projectile {
    /**
     * Base fireaball movement speed.
     */
    public static final float FIREBALL_BASE_SPEED = 0.01f;

    private final GraphicsComponent graphicsComponent;
    private final CollisionComponent collisionComponent;
    private final PhysicsComponent physicsComponent;
    private final Entity shooter;

    /**
     * 
     * @param entity Entity who spawned the fireball.
     */
    public Fireball(final Entity entity) {
        super(entity.getX(), entity.getY(), entity.getHeight() / 3, entity.getHeight() / 3);

        this.graphicsComponent = new FireballGraphicsComponent(this);
        collisionComponent = new FireballCollisionComponent(this, entity.getWorld().get());
        final float fireballSpeed = entity.getVelocity().x() >= 0 ? FIREBALL_BASE_SPEED : -FIREBALL_BASE_SPEED;
        physicsComponent = new FireballPhysicsComponent(this, fireballSpeed);
        this.shooter = entity;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public GraphicsComponent getGraphicsComponent() {
        return graphicsComponent;
    }

    /**
     * Set the new physics component.
     * @param graphicsComponent new graphics component
     */
    public void setGraphicsComponent(final GraphicsComponentRetriever graphicsComponent) {
        graphicsComponent.apply(this);
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(collisionComponent);
    }

    /**
     * Return an Optional with the PhisicsComponent of the Fireball.
     * @return PhysicsComponent of the Fireball.
     */
    @Override
    public Optional<PhysicsComponent> getPhysicsComponent() {
        return Optional.of(physicsComponent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity getShooter() {
        return shooter;
    }
}
