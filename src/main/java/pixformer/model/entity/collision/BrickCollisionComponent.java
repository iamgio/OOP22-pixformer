package pixformer.model.entity.collision;

import pixformer.model.entity.MutableEntity;

import java.util.Set;

/**
 * Collision component for the brick in the game.
 */
public class BrickCollisionComponent extends CollisionComponent {

    /**
     * {@inheritDoc}
     */
    public BrickCollisionComponent(MutableEntity entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(double dt, Set<Collision> collisions) {
        for (var collision : collisions) {
            if (collision.side() == CollisionSide.BOTTOM && super.getEntity().getWorld().isPresent()) {
                super.getEntity().getWorld().get().dropEntity(this.getEntity());
            }
        }
    }
}
