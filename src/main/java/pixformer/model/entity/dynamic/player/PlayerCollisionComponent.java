package pixformer.model.entity.dynamic.player;

import java.util.Set;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;

/**
 * Implementation of CollisionComponent for a Player entity.
 */
public class PlayerCollisionComponent extends CollisionComponent {

    /**
     * 
     * @param entity Player entity whose collisions will be managed.
     */
    protected PlayerCollisionComponent(final Player entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {

        for (var x : collisions) {
            throw new UnsupportedOperationException("Unimplemented method 'update'");
        }

    }

}
