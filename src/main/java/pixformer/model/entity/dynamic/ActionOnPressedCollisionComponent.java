package pixformer.model.entity.dynamic;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.BiConsumerCollisionReactor;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionComponent;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.CollisionSide;
import pixformer.model.entity.dynamic.player.Player;

/**
 * A collision component which makes its entity die when it collides from the
 * top with a Player.
 */
public final class ActionOnPressedCollisionComponent extends CollisionComponent {

    private final CollisionReactor reactor;

    /**
     * If the entity has a world create a {@code ActionOnPressedCollisionComponent}.
     * 
     * @param entity to be controlled.
     * @return a {@code ActionOnPressedCollisionComponent} if the entity has a world
     */
    static Optional<CollisionComponent> createWithWorldFromEntityForDying(final MutableEntity entity) {
        return entity.getWorld().map(world -> new ActionOnPressedCollisionComponent(entity, (e, ee) -> world.killEntity(e, ee)));
    }

    /**
     * @param entity to be controlled.
     * @param action the consumer to which will be passed this entity.
     */
    public ActionOnPressedCollisionComponent(final MutableEntity entity, final BiConsumer<Entity, Entity> action) {
        super(entity);
        reactor = new BiConsumerCollisionReactor(Map.of(
                Player.class::isInstance, (c, e) -> {
                    if (c == CollisionSide.TOP) {
                        action.accept(entity, e);
                    }
                }));
    }

    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        reactor.react(collisions);
    }

}
