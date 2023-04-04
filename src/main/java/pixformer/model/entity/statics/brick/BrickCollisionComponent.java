package pixformer.model.entity.statics.brick;

import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.CollisionSide;
import pixformer.model.entity.dynamic.player.Player;

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
                .filter(collision -> collision.entity() instanceof Player entity && entity.getVelocity().y() < 0)
                .forEach(collision -> {
                    if (collision.side() == CollisionSide.BOTTOM && super.getEntity().getWorld().isPresent()
                            && ((Player) collision.entity()).getPowerupBehaviour().isPresent()) {
                        final Player entity = (Player) collision.entity();
                        entity.setVelocity(entity.getVelocity().copyWithY(Math.abs(entity.getVelocity().y()) / 2));
                        super.getEntity().getWorld().get().queueEntityDrop(this.getEntity());
                    }
        });
    }
}
