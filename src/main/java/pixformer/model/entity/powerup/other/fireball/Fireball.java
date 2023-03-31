package pixformer.model.entity.powerup.other.fireball;

import java.util.Optional;

import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.Entity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.Projectile;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.physics.PhysicsComponent;
import pixformer.view.entity.powerups.fireball.FireballGraphicsComponent;

/**
 * Rapresenting fireball object spawned by player with FireFlower powerup.
 */
public class Fireball extends AbstractEntity implements DrawableEntity, DefaultRectangleBoundingBoxEntity, Projectile {
    private final float speed;

    private final GraphicsComponent graphicsComponent;
    private final CollisionComponent collisionComponent;
    private final PhysicsComponent physicsComponent;
    private final Entity shooter;

    /**
     * 
     * @param entity Entity who spawned the fireball.
     * @param speed Fireball constant speed.
     */
    public Fireball(final Entity entity, final float speed) {
        super(entity.getX(), entity.getY(), entity.getHeight() / 3, entity.getHeight() / 3);

        graphicsComponent = new FireballGraphicsComponent(this);
        collisionComponent = new FireballCollisionComponent(this, entity.getWorld().get());
        physicsComponent = new FireballPhysicsComponent(this);

        this.speed = speed;
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
     * 
     * @return current fireball speed.
     */
    public float getSpeed() {
        return this.speed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity getShooter() {
        return shooter;
    }
}
