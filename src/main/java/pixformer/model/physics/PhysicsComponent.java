package pixformer.model.physics;

import pixformer.common.Updatable;
import pixformer.common.Vector2D;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.components.Component;

/**
 * {@inheritDoc}.
 */
public class PhysicsComponent extends Component<MutableEntity> implements Updatable {

    private static final double GRAVITY = 0.00008;

    private final Vector2D force;

    /**
     * Constructor for the PhysicComponent.
     * 
     * @param entity for the physic component
     */
    public PhysicsComponent(final MutableEntity entity) {
        super(entity);
        this.force = new Vector2D(0, GRAVITY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        final MutableEntity entity = super.getEntity();
        entity.setVelocity(entity.getVelocity().sum(force));
    }
}
