package pixformer.model.entity.dynamic.reactor;

import pixformer.model.entity.Entity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.powerup.other.fireball.Fireball;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * A collision reactor that makes the entity die when hit by a fireball.
 */
public final class DieForFireCollisionReactor implements CollisionReactor {

    private final CollisionReactor inner;

    /**
     * @param dieBy consume the killer entity and kill the entity.
     */
    public DieForFireCollisionReactor(final Consumer<Entity> dieBy) {
        inner = new SingleCollisionReactor(
                collision -> collision.entity() instanceof Fireball, dieBy
        );
    }

    @Override
    public void react(final Collection<Collision> collisions) {
        inner.react(collisions);
    }
}
