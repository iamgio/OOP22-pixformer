package pixformer.model.entity.dynamic;

import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * Reactor which makes an entity die for be hit by a turtle koopa.
 */
public class DieByTurtleCollisionReactor implements CollisionReactor {

    private final CollisionReactor innerReactor;

    /**
     * @param dieBy consumer which accepts as argument the killer entity.
     */
    public DieByTurtleCollisionReactor(final Consumer<Entity> dieBy) {
        innerReactor = new SingleCollisionReactor(
            collision -> collision.entity() instanceof Koopa && ((Koopa) collision.entity()).isTurtle(),
            dieBy
        );
    }
    @Override
    public void react(final Collection<Collision> collisions) {
        innerReactor.react(collisions);
    }
}
