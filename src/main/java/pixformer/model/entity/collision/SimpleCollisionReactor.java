package pixformer.model.entity.collision;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import pixformer.model.entity.Entity;

/**
 * A simple implementation of
 * {@link pixformer.model.entity.collision.CollisionReactor}.
 */
public final class SimpleCollisionReactor implements CollisionReactor {

    private final Map<Predicate<Entity>, Consumer<CollisionSide>> reactions;

    /**
     * @param reactions a {@code Map} whose entries are composed by a
     *                  {@code Predicate<Entity>} which
     *                  determined if the reactor should react the entity colliding
     *                  and a {@code Consumer<CollisionSide>} which represents the
     *                  actual reaction to the
     *                  collision.
     */
    public SimpleCollisionReactor(final Map<Predicate<Entity>, Consumer<CollisionSide>> reactions) {
        this.reactions = new HashMap<>(reactions);
    }

    @Override
    public void react(final Collection<Collision> collisions) {
        for (final var reaction : reactions.entrySet()) {
            collisions.stream()
                    .filter(c -> reaction.getKey().test(c.entity()))
                    .map(Collision::side)
                    .forEach(reaction.getValue());
        }
    }

}
