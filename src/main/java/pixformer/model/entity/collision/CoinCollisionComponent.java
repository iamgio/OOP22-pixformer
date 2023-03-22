package pixformer.model.entity.collision;

import pixformer.model.entity.statics.Coin;

import java.util.Set;

/**
 * Collision component for the in-game coin.
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

    }
}
