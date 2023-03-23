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
                .filter(entity -> entity instanceof Player).forEach(entity -> {
                    if (entity.getWorld().isPresent()) {
                        entity.getWorld().get().endGame((Player) entity);
                    }
                });
    }
}
