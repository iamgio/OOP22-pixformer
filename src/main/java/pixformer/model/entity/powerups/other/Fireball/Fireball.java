package pixformer.model.entity.powerups.other.Fireball;

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
    public Fireball(final double x, final double y, final double width, final double height) {
        super(x, y, width, height);
        graphicsComponent = new FireballGraphicsComponent(this);
        collisionComponent = new FireballCollisionComponent(this);
        physicsComponent = new FireballPhysicsComponent(this);
    }

    @Override
    public GraphicsComponent getGraphicsComponent() {
        return graphicsComponent;
    }

    public CollisionComponent getCollisionComponent() {
        return collisionComponent;
    }
    
    public PhysicsComponent getPhysicsComponent() {
        return physicsComponent;
    }
}
