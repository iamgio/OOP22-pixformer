package pixformer.model.entity.dynamic;

import pixformer.model.entity.Entity;
import pixformer.model.entity.MutableEntity;
import pixformer.model.entity.collision.Collision;
import pixformer.model.entity.collision.CollisionReactor;
import pixformer.model.entity.collision.SolidCollisionComponent;
import pixformer.model.entity.dynamic.reactor.ActionOnPressedCollisionReactor;

import java.util.Set;
import java.util.function.Consumer;

/**
 * A collision component which makes its entity die when it collides from the
 * top with a Player.
 */
public final class ActionOnPressedCollisionComponent extends SolidCollisionComponent {

    private final CollisionReactor reactor;

//    /**
//     * If the entity has a world create a {@code ActionOnPressedCollisionComponent}.
//     *
//     * @param entity to be controlled.
//     * @return a {@code ActionOnPressedCollisionComponent} if the entity has a world
//     */
//    static Optional<CollisionComponent> createWithWorldFromEntityForDying(final MutableEntity entity) {
//        return entity.getWorld().map(world -> new ActionOnPressedCollisionComponent(entity,
//                (killed, killer) -> world.queueEntityKill(killed, killer)));
//    }

    /**
     * @param entity to be controlled.
     * @param action the consumer to which will be passed this entity.
     */
    public ActionOnPressedCollisionComponent(final MutableEntity entity, final Consumer<Entity> action) {
        super(entity);
        reactor = new ActionOnPressedCollisionReactor(action);
    }

    @Override
    public void update(final double dt, final Set<Collision> collisions) {
        super.update(dt, collisions);
        reactor.react(collisions);
    }

}
