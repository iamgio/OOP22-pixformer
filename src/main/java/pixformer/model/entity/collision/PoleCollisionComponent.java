package pixformer.model.entity.collision;

import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.statics.Pole;

import java.util.Set;

/**
 * A {@link CollisionComponent}, it manages all the interaction with the {@link Pole}
 * and specify all behaviours.
 */
public class PoleCollisionComponent extends CollisionComponent {

    /**
     * Simple constructor for the FlagCollisionComponent.
     *
     * @param entity target entity for the component
     */
    public PoleCollisionComponent(final Pole entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        collisions.stream()
                .map(Collision::entity)
                .filter(Player.class::isInstance)
                .map(entity -> (Player) entity).forEach(player -> {
                    if (player.getWorld().isPresent()) {
                        player.setVelocity(player.getVelocity().copyWithX(0));
                        player.setVelocity(player.getVelocity().y() > 0
                                ? player.getVelocity() : player.getVelocity().copyWithY(0));
                        player.getWorld().get().endGame(player);
                    }
                });
    }
}
