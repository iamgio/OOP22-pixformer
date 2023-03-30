package pixformer.model.entity.dynamic.reactor;

import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * React to a single type of collision between entities.
 */
public class SingleCollisionReactor implements CollisionReactor {

    private final Predicate<Collision> whichCollisions;
    private final Consumer<Entity> action;

    /**
     * Simple constructor for the single collision reactor.
     *
     * @param whichCollisions specify the side of the collision that has to trigger the action
     * @param action specify the behaviour of the entity when it has collided
     */
    public SingleCollisionReactor(final Predicate<Collision> whichCollisions, final Consumer<Entity> action) {
        this.whichCollisions = whichCollisions;
        this.action = action;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void react(final Collection<Collision> collisions) {
        collisions.stream()
                .filter(whichCollisions)
                .map(Collision::entity)
                .forEach(action);
    }
}
