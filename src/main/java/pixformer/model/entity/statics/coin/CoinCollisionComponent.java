package pixformer.model.entity.statics.coin;

import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.dynamic.player.Player;

import java.util.Set;

/**
 * A {@link CollisionComponent} component for the in-game coin, specifying behaviours
 * when something collide with it.
 */
public class CoinCollisionComponent extends CollisionComponent {

    /**
     * Simple constructor for the coin collision component.
     *
     * @param entity coin with this collision component
     */
    public CoinCollisionComponent(final Coin entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        collisions.stream()
                .filter(collision -> collision.entity() instanceof Player)
                .forEach(collision ->  {
                    if (super.getEntity().getWorld().isPresent()) {
                        super.getEntity().getWorld().get().queueEntityKill(super.getEntity(), collision.entity());
                    }
        });
    }
}
