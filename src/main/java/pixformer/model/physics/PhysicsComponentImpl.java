package pixformer.model.physics;

import pixformer.common.Vector2D;

/**
 * {@inheritDoc}.
 */
public class PhysicsComponentImpl implements PhysicsComponent {
    private Vector2D gravity;

    /**
     * Constructor for the PhysicComponent.
     * 
     * @param vector
     */
    public PhysicsComponentImpl(final Vector2D vector) {
        this.gravity = vector;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector2D getGravity() {
        return this.gravity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setGravity(final Vector2D vector) {
        this.gravity = vector;
    }
}
