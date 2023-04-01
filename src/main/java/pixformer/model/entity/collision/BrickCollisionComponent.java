package pixformer.model.entity.collision;

import pixformer.model.entity.MutableEntity;

import java.util.Set;

/**
 * A {@link CollisionComponent} component for the brick in the game, specifying behaviours
 * when something collide with it.
 */
public class BrickCollisionComponent extends CollisionComponent {

    /**
     * Simple constructor for the BrickCollisionComponent.
     *
     * @param entity entity with this collision component
     */
    public BrickCollisionComponent(final MutableEntity entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        collisions.stream()
                .filter(collision -> collision.entity() instanceof MutableEntity entity && entity.getVelocity().y() < 0)
                .forEach(collision -> {
                    if (collision.side() == CollisionSide.BOTTOM && super.getEntity().getWorld().isPresent()) {
                        super.getEntity().getWorld().get().queueEntityDrop(this.getEntity());
                        MutableEntity entity = (MutableEntity) collision.entity();
                        entity.setVelocity(entity.getVelocity().copyWithY(entity.getVelocity().y() / 2));
                    }
        });
    }
}
