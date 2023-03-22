package pixformer.model.entity.collision;

import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.statics.Flag;

import java.util.Set;

/**
 * Flag collision component, it manages all the interaction with the flag (or pole)
 * and specify all behaviours.
 */
public class FlagCollisionComponent extends CollisionComponent {

    /**
     * Simple constructor for the FlagCollisionComponent.
     *
     * @param entity target entity for the component
     */
    public FlagCollisionComponent(final Flag entity) {
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
