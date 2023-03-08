package pixformer.model.physics;

import pixformer.common.Updatable;
import pixformer.common.Vector2D;
import pixformer.model.entity.Entity;

/**
 * {@inheritDoc}.
 */
public class PhysicsComponent implements Updatable {
    private Vector2D gravity;
    private Entity entity;

    /**
     * Constructor for the PhysicComponent.
     * 
     * @param vector
     */
    public PhysicsComponent(final Entity entity) {
        this.gravity = new Vector2D(0, -9.81);
        this.entity = entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        entity.setVelocity(entity.getVelocity().sum(gravity));
    }
}
