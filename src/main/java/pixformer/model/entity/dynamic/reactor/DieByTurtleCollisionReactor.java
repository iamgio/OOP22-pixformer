package pixformer.model.entity.dynamic.reactor;

import pixformer.model.entity.Entity;
import pixformer.model.entity.Projectile;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.dynamic.enemy.koopa.Koopa;

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
        innerReactor = new DieByProjectileCollisionReactor(Koopa.class::isInstance, dieBy);
    }

    @Override
    public void react(final Collection<Collision> collisions) {
        innerReactor.react(collisions);
    }

    /**
     * @param entity the candidate to be a {@link Projectile}
     * @return the shooter of the {@code entity} if {@code entity} is a {@link Projectile},
     * otherwise return {@code entity}.
     */
    private Entity getShooterIfProjectile(final Entity entity) {
        if (entity instanceof Projectile projectile) {
            return projectile.getShooter();
        }
        return entity;
    }
}
