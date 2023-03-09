package pixformer.model.physics;

import pixformer.common.Updatable;
import pixformer.common.Vector2D;
import pixformer.model.entity.Entity;

/**
 * {@inheritDoc}.
 */
public class PhysicsComponent implements Updatable {

    private static final double GRAVITY = 9.81;

    private Vector2D force;
    private Entity entity;

    /**
     * Constructor for the PhysicComponent.
     * 
     * @param entity for the physic component
     */
    public PhysicsComponent(final Entity entity) {
        this.force = new Vector2D(0, -GRAVITY);
        this.entity = entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        entity.setVelocity(entity.getVelocity().sum(force));
    }
}
