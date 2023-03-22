package pixformer.model.entity.collision;

import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.statics.Coin;

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
    public void update(double dt, Set<Collision> collisions) {
        for (var collision : collisions.stream().filter(x -> x.entity() instanceof Player).toList()) {
            if (super.getEntity().getWorld().isPresent()) {
                super.getEntity().getWorld().get().killEntity(super.getEntity(), collision.entity());
            }
        }
    }
}
