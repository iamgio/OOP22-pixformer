package pixformer.model.entity.dynamic;

import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SingleCollisionReactor implements CollisionReactor {

    private final Predicate<Collision> whichCollisions;
    private final Consumer<Entity> action;

    public SingleCollisionReactor(final Predicate<Collision> whichCollisions, final Consumer<Entity> action) {
        this.whichCollisions = whichCollisions;
        this.action = action;
    }
    @Override
    public void react(final Collection<Collision> collisions) {
        collisions.stream()
                .filter(whichCollisions)
                .map(Collision::entity)
                .forEach(action);
    }
}
