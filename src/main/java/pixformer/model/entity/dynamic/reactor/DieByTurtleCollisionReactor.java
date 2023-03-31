package pixformer.model.entity.dynamic.reactor;

import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.dynamic.enemy.koopa.Koopa;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * Reactor which makes an entity die for be hit by a turtle koopa.
 */
public final class DieByTurtleCollisionReactor implements CollisionReactor {

    private final CollisionReactor innerReactor;

    /**
     * @param dieBy consumer which accepts as argument the killer entity.
     */
    public DieByTurtleCollisionReactor(final Consumer<Entity> dieBy) {
        innerReactor = new DieByProjectileCollisionReactor(Koopa.class::isInstance,
                turtle ->  {
                    if (turtle.getVelocity().x() != 0) {
                        dieBy.accept(turtle);
                    }
                }
        );
    }

    @Override
    public void react(final Collection<Collision> collisions) {
        innerReactor.react(collisions);
    }

}
