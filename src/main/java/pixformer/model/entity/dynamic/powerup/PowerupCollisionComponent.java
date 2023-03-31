package pixformer.model.entity.dynamic.powerup;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.SolidCollisionComponent;
import pixformer.model.entity.dynamic.player.Player;
import pixformer.model.entity.dynamic.reactor.SingleCollisionReactor;

import java.util.Set;
import java.util.function.Consumer;

/**
 * A collision component for the powerups. It kills the controlled entity when colliding with a Player.
 */
public final class PowerupCollisionComponent extends SolidCollisionComponent {

    private final CollisionReactor collisionReactor;

    /**
     * @param entity to be controlled.
     * @param takenBy a consumer which accepts the entity who took the powerup.
     */
    public PowerupCollisionComponent(final MutableEntity entity, final Consumer<Entity> takenBy) {
        super(entity);
        collisionReactor = new SingleCollisionReactor(
                collision -> collision.entity() instanceof Player,
                takenBy
        );
    }

    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        super.update(dt, collisions);
        collisionReactor.react(collisions);
    }
}
