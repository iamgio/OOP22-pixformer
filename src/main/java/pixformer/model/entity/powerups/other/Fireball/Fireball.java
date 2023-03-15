package pixformer.model.entity.powerups.other.Fireball;

import java.util.Optional;

import pixformer.model.World;
import pixformer.model.entity.AbstractEntity;
import pixformer.model.entity.DrawableEntity;
import pixformer.model.entity.GraphicsComponent;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.DefaultRectangleBoundingBoxEntity;
import pixformer.model.physics.PhysicsComponent;

/**
 * Rapresenting fireball object spawned by player with FireFlower powerup.
 */
public class Fireball extends AbstractEntity implements DrawableEntity, DefaultRectangleBoundingBoxEntity {
    private final float speed;

    private GraphicsComponent graphicsComponent;
    private CollisionComponent collisionComponent;
    private PhysicsComponent physicsComponent;

    /**
     * 
     * @param x Starting X position.
     * @param y Starting Y position.
     * @param width Width.
     * @param height Height.
     */
    public Fireball(final double x, final double y, final double width, final double height, final float speed, final World world) {
        super(x, y, width, height);

        graphicsComponent = new FireballGraphicsComponent(this);
        collisionComponent = new FireballCollisionComponent(this, world);
        physicsComponent = new FireballPhysicsComponent(this);

        this.speed = speed;
        world.spawnEntity(this);
    }

    @Override
    public GraphicsComponent getGraphicsComponent() {
        return graphicsComponent;
    }

    @Override
    public Optional<CollisionComponent> getCollisionComponent() {
        return Optional.of(collisionComponent);
    }
    
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
}
