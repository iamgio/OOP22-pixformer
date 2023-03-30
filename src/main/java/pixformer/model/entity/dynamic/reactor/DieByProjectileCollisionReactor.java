package pixformer.model.entity.dynamic.reactor;

import pixformer.model.entity.Entity;
import pixformer.model.entity.Projectile;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.dynamic.enemy.koopa.Koopa;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * CollisionReactor which reacts to collision from any direction of {@link Projectile}.
 */
public final class DieByProjectileCollisionReactor implements CollisionReactor {

    private final CollisionReactor inner;

    /**
     * @param whichEntities determines to which entity this reactor should react
     * @param dieBy consumer which accepts as argument the killer entity.
     */
    public DieByProjectileCollisionReactor(final Predicate<Entity> whichEntities, final Consumer<Entity> dieBy) {
        inner = new SingleCollisionReactor(
            collision -> collision.entity() instanceof Projectile && whichEntities.test(collision.entity()),
            killer -> dieBy.accept(getShooterIfProjectile(killer))
        );
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

    @Override
    public void react(final Collection<Collision> collisions) {
        inner.react(collisions);
    }
}
