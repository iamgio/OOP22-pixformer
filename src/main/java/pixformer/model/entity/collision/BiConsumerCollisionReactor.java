package pixformer.model.entity.collision;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import pixformer.model.entity.Entity;

/**
 * A simple implementation of
 * {@link pixformer.model.entity.collision.CollisionReactor}.
 */
public final class BiConsumerCollisionReactor implements CollisionReactor {

    private final Map<Predicate<Entity>, BiConsumer<CollisionSide, Entity>> reactions;

    /**
     * @param reactions a {@code Map} whose entries are composed by a
     *                  {@code Predicate<Entity>} which
     *                  determined if the reactor should react the entity colliding
     *                  and a {@code BiConsumer<CollisionSide, Entity>} which
     *                  represents the
     *                  actual reaction to the collision.
     */
    public BiConsumerCollisionReactor(final Map<Predicate<Entity>, BiConsumer<CollisionSide, Entity>> reactions) {
        this.reactions = reactions;
    }

    @Override
    public void react(final Collection<Collision> collisions) {
        for (final var reaction : reactions.entrySet()) {
            collisions.stream()
                    .filter(c -> reaction.getKey().test(c.entity()))
                    .forEach(c -> reaction.getValue().accept(c.side(), c.entity()));
        }
    }

}
